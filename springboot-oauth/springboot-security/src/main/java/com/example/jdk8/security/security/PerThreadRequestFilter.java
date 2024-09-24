package com.example.jdk8.security.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaojh
 * @description: 使用 OncePerRequestFilter 保证在单个请求线程中每个请求仅调用一次
 * @date 2024-09-24
 */
@Configuration
public class PerThreadRequestFilter extends OncePerRequestFilter {

    @Resource
    private StringRedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal
            (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");

        if (ObjectUtils.isEmpty(token)){
            filterChain.doFilter(request,response);
            return;
        }

        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> errMsg = new HashMap<>();
            errMsg.put("code","200");
            errMsg.put("msg","访问失败，请重新登录");
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().print(errMsg.toString());
            return;
        }

        Integer userId = Integer.valueOf(claims.getSubject());

        UserContext.setUser(userId);
        String userAdmin = redisTemplate.opsForValue().get("userId" + userId);

        AdminLogin adminLogin = JSONUtil.toBean(userAdmin, AdminLogin.class);


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(adminLogin.getUsername(), adminLogin.getUsername(), null);
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(null, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request,response);
    }
}
