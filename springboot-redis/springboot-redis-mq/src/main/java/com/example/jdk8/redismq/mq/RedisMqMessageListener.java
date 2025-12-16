package com.example.jdk8.redismq.mq;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;


/**
 * Author zhaojh0912
 * Description TODO
 * CreateDate 2025/12/15 21:49
 * Version 1.0
 */
@Component
public class RedisMqMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String payload = new String(message.getBody());
        System.out.println("【收到消息】Channel: " + channel + ", Message: " + payload);

        // TODO: 业务逻辑处理
        // 注意：不要在此做耗时操作！否则会阻塞 Redis 线程。
        // 建议提交到线程池或异步处理。
    }
}