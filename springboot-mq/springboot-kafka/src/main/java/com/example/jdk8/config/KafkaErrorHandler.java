package com.example.jdk8.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.KafkaException;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaErrorHandler implements ErrorHandler {

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data) {
        if (thrownException instanceof KafkaException) {
            // 检查 value 是否为 null，如果是，则忽略错误
            if (data.value() == null) {
                // 记录日志或其他处理
                log.info("Ignored null value for key:{}", data.key());
                return;
            }
        }
        // 对于其他错误，重新抛出异常或执行其他处理
        log.info("Ignored null value for key:{}", data.key());
        throw new RuntimeException(thrownException);
    }
}


