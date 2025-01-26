package com.example.jdk8.tenant.mybatis.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaojh
 * @version 1.0
 * @description MVC的配置，涉及到 请求、跨域、路径、资源的释放、拦截
 * @date 2025/1/21 下午4:25
 */
@Configurable
@Configuration
public class WebConfig implements WebMvcConfigurer {
}
