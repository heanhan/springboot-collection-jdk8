package com.example.jdk8.powerjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * powerjob 启动类
 * 使用 @EnableScheduling 开启任务
 *
 */
@EnableScheduling
@SpringBootApplication
public class PowerJobApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(PowerJobApplication.class,args);
    }
}
