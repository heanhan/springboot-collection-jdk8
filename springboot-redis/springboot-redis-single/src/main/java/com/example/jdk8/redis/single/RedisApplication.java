package com.example.jdk8.redis.single;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * redis使用的入口
 *
 */

@SpringBootApplication
public class RedisApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RedisApplication.class,args);
    }
}
