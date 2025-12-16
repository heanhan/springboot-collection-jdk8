package com.example.jdk8.redismq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author zhaojh0912
 * Description TODO
 * CreateDate 2025/12/15 21:36
 * Version 1.0
 */

@Data
@ConfigurationProperties(prefix = "redissubscrip.mq")
public class RedisMqProperties {

    private boolean enabled = true;
    private String clusterNodes;        // 新增：集群节点
    private String host = "localhost";  // 单机
    private int port = 6379;
    private int database = 0;
    private String password;
    private long timeout = 3000L;
    private int maxRedirects = 5;       // 集群重定向次数
}
