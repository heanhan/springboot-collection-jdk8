package com.example.jdk8.minio.es.service;


import com.example.jdk8.minio.es.entity.FileTable;
import lombok.SneakyThrows;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:53
 */
public interface FileTableService {

    /**
     * 实例化完成后创建索引
     */
    void createIndex();


    /**
     * 新增数据
     *
     * @param fileTable 实例对象
     * @return 实例对象
     */
    FileTable insert(FileTable fileTable);


    /**
     * 获取file的文件内容，上次到es中来做检索
     *
     * @param file       文件对象
     * @param bucketName 桶名称
     */
    void uploadFile(MultipartFile file, String bucketName);

    /**
     * @description: 高亮查询
     * @date: 2025/1/22
     * @param: id
     **/
    List<FileTable> getInfoHighlight(Long id);
}
