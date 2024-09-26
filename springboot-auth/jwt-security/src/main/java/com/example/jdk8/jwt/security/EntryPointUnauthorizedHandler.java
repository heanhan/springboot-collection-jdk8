package com.example.jdk8.jwt.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaojh
 * @description: 当用户未通过认证访问受保护的资源时
 * @date 2024-09-24
 */
@Slf4j
@Configuration
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {


    /**
     * 开始身份验证方案。
     * 在调用此方法之前， ExceptionTranslationFilter将会用请求的目标 URL 填充名为AbstractAuthenticationProcessingFilter. SPRING_SECURITY_SAVED_REQUEST_KEY的HttpSession属性。
     * 实现应该根据需要修改ServletResponse上的标头以开始身份验证过程
     * @param request       that resulted in an <code>AuthenticationException</code>
     * @param response      so that the user agent can begin authentication
     * @param authException that caused the invocation
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("进入认证通过，但是没有权限");
    }

}
