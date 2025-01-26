package com.example.jdk8.tenant.mybatis.system.config;

import com.example.jdk8.tenant.mybatis.system.vo.DataSourceType;
import com.example.jdk8.tenant.mybatis.system.vo.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 自定义  动态切换数据源切面
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class DataSourceAspect {

    /**
     * 自定义个切点
     */
    @Pointcut(value = "execution (* com.example.jdk8.tenant.mybatis..controller.*.*(..))")
    public void postCutPoint(){
    }

    /**
     * 前置通知
     * @param joinPoint
     * @return
     */
    @Before(value = "postCutPoint()")
    public void before(JoinPoint joinPoint){
        //获取请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        // 从token中解析用户信息
        String token = request.getHeader("tokne");//从请求头里获取token
        LoginInfo loginInfo = LoginInfo.getLoginInfoByToken(token);
        if (loginInfo == null) {
            loginInfo = new LoginInfo();
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MyDataSource myDataSource = null;
        //优先判断方法上的注解
        if (method.isAnnotationPresent(MyDataSource.class)) {
            myDataSource = method.getAnnotation(MyDataSource.class);
        } else if (method.getDeclaringClass().isAnnotationPresent(MyDataSource.class)) {
            //其次判断类上的注解
            myDataSource = method.getDeclaringClass().getAnnotation(MyDataSource.class);
        }
        if (myDataSource != null) {
            DataSourceType dataSourceType = myDataSource.type();
            log.info("this is datasource: " + dataSourceType);
            if (dataSourceType.equals(DataSourceType.TENANT)) {
                loginInfo.setTenantId(myDataSource.value());
            }
        }
        LoginInfoHolder.setTenant(loginInfo);
    }

    /**
     * 后置通知  实现将不用的组合的信息统 TreadLocal中移除 解决 内存溢出的问题
     * @param joinPoint
     */
    @After("postCutPoint()")
    public void after(JoinPoint joinPoint) {
        LoginInfoHolder.clear();
    }
}
