package com.example.jdk8.minio.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * SpringBoot + Minio + ElasticSearch实现文件内容检索
 */
@EnableElasticsearchRepositories
@SpringBootApplication
public class MinioEsApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MinioEsApplication.class,args);
    }
}
