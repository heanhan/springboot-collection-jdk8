package com.example.jdk8.redismq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Hello world!
 *
 */

@EnableConfigurationProperties
@SpringBootApplication
public class RedisMqApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RedisMqApplication.class);
    }
}
