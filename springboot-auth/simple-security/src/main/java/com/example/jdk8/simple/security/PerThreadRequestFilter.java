package com.example.jdk8.simple.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaojh
 * @description: 使用 OncePerRequestFilter 保证在单个请求线程中每个请求仅调用一次
 * @date 2024-09-24
 */
@Configuration
public class PerThreadRequestFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 从请求头获取token
        String token = request.getHeader("token");
        // 检查获取到的token是否为空或空白字符串。(判断给定的字符串是否包含文本)
        if (!StringUtils.hasText(token)) {
            // 如果token为空，则直接放行请求到下一个过滤器，不做进一步处理并结束当前方法，不继续执行下面代码。
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token
        String userAccount;
        try {
            //执行逻辑
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        // 放行
        filterChain.doFilter(request, response);

    }
}
