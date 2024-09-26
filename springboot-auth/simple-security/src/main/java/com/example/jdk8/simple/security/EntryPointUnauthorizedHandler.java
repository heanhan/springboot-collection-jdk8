package com.example.jdk8.simple.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojh
 * @description: 当用户未通过认证访问受保护的资源时：即认证失败
 * @date 2024-09-24
 */
@Slf4j
@Configuration
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {


    /**
     * 开始身份验证方案。
     * 在调用此方法之前， ExceptionTranslationFilter将会用请求的目标 URL 填充名为AbstractAuthenticationProcessingFilter. SPRING_SECURITY_SAVED_REQUEST_KEY的HttpSession属性。
     * 实现应该根据需要修改ServletResponse上的标头以开始身份验证过程
     * @param request  请求
     * @param response  响应：构建输出打印
     * @param authException 异常信息
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.info("认证未通过原因：{}", authException.getMessage());
        Map<String, String> errMsg = new HashMap<>();
        //构建一个返回的json,数据接口保证和 ResultBody格式一致
        response.setContentType("text/json;charset=utf-8");
        errMsg.put("code","401");
        errMsg.put("message",authException.getMessage());
        errMsg.put("result",null);
        response.getWriter().println(JSONObject.toJSON(errMsg));
    }

}
