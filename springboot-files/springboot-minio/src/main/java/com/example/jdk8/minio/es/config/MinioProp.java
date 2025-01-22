package com.example.jdk8.minio.es.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhaojh
 * @version 1.0
 * @description TODO
 * @date 2025/1/22 下午3:14
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProp {
    // minio 连接地址
    private String endpoint;

    // 公钥
    private String accessKey;

    // 私钥
    private String secretKey;
}

