package com.example.jdk8.mdc.config;

import com.example.jdk8.mdc.task.MDCTaskDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author zhaojh
 * @description: 自定义的线程池
 * @date 2024-10-12
 */
@Configuration
public class PoolConfig {
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(10);
        //配置队列大小
        executor.setQueueCapacity(100);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("mdc-trace-");
        // 异步MDC
        executor.setTaskDecorator(new MDCTaskDecorator());
        //执行初始化
        executor.initialize();
        return executor;
    }
}

