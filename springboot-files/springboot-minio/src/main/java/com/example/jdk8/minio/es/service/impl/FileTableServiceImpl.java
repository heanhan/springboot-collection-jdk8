package com.example.jdk8.minio.es.service.impl;


import com.example.jdk8.minio.es.dao.FileTableDao;
import com.example.jdk8.minio.es.entity.FileTable;
import com.example.jdk8.minio.es.service.FileTableService;
import com.example.jdk8.minio.es.utils.FileUtils;
import com.example.jdk8.minio.es.utils.MinioUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:53
 */

@Slf4j
@Service
public class FileTableServiceImpl implements FileTableService {


    @Resource
    private FileTableDao fileTableDao;

    @Resource
    private ElasticsearchOperations elasticsearchOperations;

    @Resource
    private MinioUtils minioUtils;

    @Resource
    private FileUtils fileUtils;

    /**
     * 实例化完成后创建索引
     */
    @PostConstruct
    public void createIndex() {
        IndexOperations operations = elasticsearchOperations.indexOps(FileTable.class);
        if (!operations.exists()) {
            operations.create();
        }
        Document document = operations.createMapping();
        operations.putMapping(document);
    }


    /**
     * 新增数据
     *
     * @param fileTable 实例对象
     * @return 实例对象
     */
    @Override
    public FileTable insert(FileTable fileTable) {
        fileTableDao.save(fileTable);
        return fileTable;
    }


    /**
     * 获取file的文件内容，上次到es中来做检索
     *
     * @param file       文件对象
     * @param bucketName 桶名称
     */
    @Override
    @SneakyThrows
    public void uploadFile(MultipartFile file, String bucketName) {
        minioUtils.createBucket(bucketName);
        // 生产服务器文件名
        String objectName = bucketName + UUID.randomUUID().getLeastSignificantBits() + "_" + file.getOriginalFilename();
        Assert.notNull(file.getOriginalFilename(), "文件名不能为空");
        String fileType = file.getOriginalFilename().split("\\.")[1];
        minioUtils.putObject(bucketName, objectName, file.getInputStream(), file.getSize(), fileType);
        // 插入数据库数据
        String fileUrl = minioUtils.getObjectUrl(bucketName, objectName);
        FileTable fileTable = new FileTable();
        fileTable.setFileName(objectName);
        fileTable.setFilePath(fileUrl);
        fileTable.setIsDeleted(0);//数据有效
        fileTable.setFileType(fileType);
        fileTable.setFileSize(file.getSize());
        fileTableDao.save(fileTable);
        // 读取文件内容，上传到es，方便后续的检索  可以考虑使用消息队列，提高效率  因为读取文件内容比较耗时
        // 这里为了演示，直接读取文件内容，上传到es
        String fileContent = fileUtils.readFileContent(file.getResource().getFile(), fileType);
        fileTable.setFileContent(fileContent);
        fileTableDao.save(fileTable);
    }

    @Override
    public List<FileTable> getInfoHighlight(Long id) {
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.multiMatchQuery("手册", "fileName", "fileContent"));
        queryBuilder.withQuery(QueryBuilders.termQuery("id", id));
        // 设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        String[] fieldNames = {"fileName", "fileContent"};
        for (String fieldName : fieldNames) {
            highlightBuilder.field(fieldName);
        }
        highlightBuilder.preTags("<em>");
        highlightBuilder.postTags("</em>");
        highlightBuilder.order();
        queryBuilder.withHighlightBuilder(highlightBuilder);
//        queryBuilder.withHighlightFields(new HighlightBuilder.Field("fileName"));
        // 也可以添加分页和排序
        SortBuilder<FieldSortBuilder> sortBuilder = new FieldSortBuilder("fileSize").order(SortOrder.DESC);
        queryBuilder.withSort(sortBuilder).withPageable(PageRequest.of(0, 10)); // 表示第一页，每页10条
        NativeSearchQuery nativeSearchQuery = queryBuilder.build();
        SearchHits<FileTable> searchHits = elasticsearchOperations.search(nativeSearchQuery, FileTable.class);
        searchHits.forEach(item -> {
            FileTable fileTable = item.getContent();
            System.out.println("Highlighted FileName: " + item.getHighlightFields().get("fileName"));
            System.out.println("Highlighted FileContent: " + item.getHighlightFields().get("fileContent"));
        });
        ArrayList<FileTable> fileTables = new ArrayList<>();
        searchHits.forEach(item -> {
            fileTables.add(item.getContent());
        });

        return fileTables;
    }
}
