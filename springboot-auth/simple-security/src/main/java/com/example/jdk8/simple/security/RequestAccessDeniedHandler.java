package com.example.jdk8.simple.security;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojh
 * @description: 处理器作用：当认证成功的用户访问受保护的资源，但是权限不够，则会进入这个处理器进行处理，自定义处理器返回特定的提示信息给客户端
 * 用户账号有效，但是没有权限的处理
 * @date 2024-09-24
 */
@Slf4j
@Configuration
public class RequestAccessDeniedHandler implements AccessDeniedHandler {
    /**
     *
     * @param request
     * @param response
     * @param accessDeniedException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.info("进入认证通过但是权限不足的处理器内部");
        log.info("失败原因：{}",accessDeniedException.getMessage());
        Map<String,Object> map = new HashMap<>();
        map.put("code",403);
        map.put("message",accessDeniedException.getMessage());
        map.put("result",null);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(JSONObject.toJSON(map));

    }
}
