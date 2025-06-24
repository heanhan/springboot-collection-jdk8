package com.example.jdk8.comsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author zhaojh0912
 * Description 消费者
 * CreateDate 2025/6/24 22:44
 * Version 1.0
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "my-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}