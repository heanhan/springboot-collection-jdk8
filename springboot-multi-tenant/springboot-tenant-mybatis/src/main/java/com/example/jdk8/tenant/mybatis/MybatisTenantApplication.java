package com.example.jdk8.tenant.mybatis;

import com.example.jdk8.tenant.mybatis.system.config.DynamicDatabaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */


@EnableWebMvc
@SpringBootApplication
public class MybatisTenantApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MybatisTenantApplication.class,args);
    }
}
