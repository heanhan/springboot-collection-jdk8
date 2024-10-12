package com.example.jdk8.mdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用mdc 映射诊断内容  实现多线程下的日志打印
 *
 */
@SpringBootApplication
public class MDCApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MDCApplication.class, args);
    }
}
