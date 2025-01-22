package com.example.jdk8.minio.es.config;


import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaojh
 * @version 1.0
 * @description minio的配置类
 * @date 2025/1/22 下午3:14
 */
@Configuration
public class MinioConfig {

    private final MinioProp minioProp;

    public MinioConfig(MinioProp minioProp) {
        this.minioProp = minioProp;
    }

    /**
     * minio客户端
     *
     * @return
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(minioProp.getEndpoint())
                .credentials(minioProp.getAccessKey(), minioProp.getSecretKey())
                .build();
    }
}

