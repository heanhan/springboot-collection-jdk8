package com.example.jdk8.mdc.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author zhaojh
 * @description: 自定义的切面
 * @date 2024-10-12
 */
@Aspect
@Component
public class TraceAspect {

    @Pointcut("execution(* com.example..*.*(..))")
    public void allMethods() {}

    @Before("allMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // 生成traceId，这里只是简单示例，实际应用中可能需要更复杂的逻辑
        String traceId = UUID.randomUUID().toString();
        MDC.put("traceId", traceId);
    }

    @After("allMethods()")
    public void afterAdvice() {
        // 清除MDC中的traceId
        MDC.clear();
    }
}
