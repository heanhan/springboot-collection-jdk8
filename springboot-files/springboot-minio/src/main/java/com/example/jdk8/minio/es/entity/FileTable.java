package com.example.jdk8.minio.es.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author zhaojh
 * @version 1.0
 * @description 索引文档
 * @date 2025/1/22 下午3:44
 */
@Data
@Document(indexName = "file_table")
public class FileTable implements Serializable {

    /**
     * 文件表主键，自增 ID
     */
    @Id
    private Long id;
    /**
     * 文件名
     * text  可分词，不可以聚合
     */
    @Field(name = "fileName", type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String fileName;

    /**
     * 文件内容
     */
    @Field(name = "fileContent", type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String fileContent;

    /**
     * 文件类型
     * keyword  不可分词  但是可以聚合
     */
    @Field(name = "fileType", type = FieldType.Keyword)
    private String fileType;
    /**
     * 文件大小
     */
    @Field(name = "fileSize", type = FieldType.Long)
    private Long fileSize;
    /**
     * 文件路径
     */
    @Field(name = "filePath", type = FieldType.Text, index = false)
    private String filePath;
    /**
     * 逻辑删除标志，0 未删除  1 已删除
     */
    private Integer isDeleted;
}

