package com.example.jdk8.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author zhaojh0912
 * Description 控制层-生产者
 * CreateDate 2025/6/24 22:42
 * Version 1.0
 */
@RequestMapping(value = "/produce")
@RestController
public class KafkaProducerController {

    private static final String TOPIC = "test-topic";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public String sendMessage(@RequestBody String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent: " + message;
    }
}
