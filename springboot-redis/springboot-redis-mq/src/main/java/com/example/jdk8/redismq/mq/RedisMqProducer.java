package com.example.jdk8.redismq.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * Author zhaojh0912
 * Description TODO
 * CreateDate 2025/12/15 21:50
 * Version 1.0
 */
@Service
public class RedisMqProducer {

    @Autowired
    @Qualifier("redisMqTemplate")
    private RedisTemplate<String, Object> redisMqTemplate;

    @Value(value = "${redissubscrip.mq.topic-name:null}")
    private String topicName;

    public void sendMessage(String message) {
        redisMqTemplate.convertAndSend(topicName, message);
    }
}
