package com.example.jdk8.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@MapperScan("com.example.jdk8.sharding.mapper")
@SpringBootApplication
public class ShardingApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ShardingApplication.class,args);
    }
}
