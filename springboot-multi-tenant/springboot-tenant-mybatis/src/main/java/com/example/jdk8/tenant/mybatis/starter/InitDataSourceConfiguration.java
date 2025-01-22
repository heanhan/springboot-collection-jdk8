package com.example.jdk8.tenant.mybatis.starter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhaojh
 * @version 1.0
 * @description 项目启动的首先加载的类
 *              ApplicationListener 用于监听spring 事件的核心接口，它属于 Spring 的事件机制，用于监听容器中发布的 ApplicationEvent 及其子类事件。
 *              当特定事件发生时，Spring 会通知所有注册的监听器执行相应逻辑。
 *              常见内置事件：
 *              ContextRefreshedEvent	 容器初始化或刷新完成时
 *              ContextStartedEvent	     容器启动时
 *              ContextStoppedEvent	     容器停止时
 *              ContextClosedEvent	     容器关闭时
 *              RequestHandledEvent	     HTT 请求处理完成后
 *
 * @date 2025/1/21 下午5:09
 */
@Slf4j
@Component
public class InitDataSourceConfiguration implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * 处理应用程序事件。
     * @param event 要响应的事件
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


    }
}
