package com.example.jdk8.redismq.config;

import com.example.jdk8.redismq.mq.RedisMqMessageListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Arrays;


/**
 * Author zhaojh0912
 * Description TODO
 * CreateDate 2025/12/15 21:45
 * Version 1.0
 */

@Configuration
@EnableConfigurationProperties(RedisMqProperties.class)
public class RedisMqConfig {

    @Resource
    private RedisMqProperties mqProperties;


    @Value(value = "${redissubscrip.mq.topic-name:null}")
    private String topicName;

    public RedisMqConfig(RedisMqProperties mqProperties,
                         @Value("${redissubscrip.topic-name:channel_cdss}") String topicName) {
        this.mqProperties = mqProperties;
        this.topicName = topicName;
    }

    @Bean("redisMqConnectionFactory")
    public LettuceConnectionFactory redisMqConnectionFactory() {
        if (!mqProperties.isEnabled()) {
            return null;
        }

        if (mqProperties.getClusterNodes() != null && !mqProperties.getClusterNodes().trim().isEmpty()) {
            // 集群模式
            RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(
                    Arrays.asList(mqProperties.getClusterNodes().split(","))
            );
            if (mqProperties.getPassword() != null && !mqProperties.getPassword().isEmpty()) {
                clusterConfig.setPassword(RedisPassword.of(mqProperties.getPassword()));
            }
            clusterConfig.setMaxRedirects(mqProperties.getMaxRedirects());

            // 构建基础客户端配置（仅设置超时）
            LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                    .commandTimeout(Duration.ofMillis(mqProperties.getTimeout()))
                    .build();

            return new LettuceConnectionFactory(clusterConfig, clientConfig);
        } else {
            // 单机模式
            RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration();
            standaloneConfig.setHostName(mqProperties.getHost());
            standaloneConfig.setPort(mqProperties.getPort());
            standaloneConfig.setDatabase(mqProperties.getDatabase());
            if (mqProperties.getPassword() != null && !mqProperties.getPassword().isEmpty()) {
                standaloneConfig.setPassword(RedisPassword.of(mqProperties.getPassword()));
            }

            LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                    .commandTimeout(Duration.ofMillis(mqProperties.getTimeout()))
                    .build();

            return new LettuceConnectionFactory(standaloneConfig, clientConfig);
        }
    }
    /**
     * RedisTemplate 用于发送消息（生产者）
     */
    @Bean("redisMqTemplate")
    public RedisTemplate<String, Object> redisMqTemplate() {
        if (!mqProperties.isEnabled()) {
            return null;
        }
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisMqConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 消息监听容器（消费者）
     */
    @Bean("redisMessageListenerContainer")
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisMqMessageListener listener) {
        if (!mqProperties.isEnabled()) {
            return null;
        }
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisMqConnectionFactory());
        container.addMessageListener(listener, new org.springframework.data.redis.listener.ChannelTopic(topicName));
        container.setErrorHandler(e -> System.err.println("Redis MQ Listener Error: " + e.getMessage()));
        return container;
    }
}
