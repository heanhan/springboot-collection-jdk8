package com.example.jdk8;

import com.example.jdk8.config.ResponseBodyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpandWebStarterAutoConfiguration {

    @Bean //将ResponseBodyHandler注入spring容器中
    public ResponseBodyHandler responseBodyHandler(){
        return  new ResponseBodyHandler();
    }

}

