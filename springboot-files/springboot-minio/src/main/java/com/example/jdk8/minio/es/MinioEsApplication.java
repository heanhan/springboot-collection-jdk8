package com.example.jdk8.minio.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot + Minio + ElasticSearch实现文件内容检索
 */
@SpringBootApplication
public class MinioEsApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MinioEsApplication.class,args);
    }
}
