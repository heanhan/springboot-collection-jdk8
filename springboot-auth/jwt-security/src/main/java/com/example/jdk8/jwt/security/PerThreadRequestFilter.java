package com.example.jdk8.jwt.security;

import com.example.jdk8.jwt.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
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

    @Resource
    private JwtUtil jwtUtil;

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
            Claims claims = jwtUtil.parseJWT(token);
            userAccount = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        // 从redis 中 获取 用户信息
        String redisKey = "login:" + userAccount;
        // redis 获取 键 对应 数据
//        LoginUser loginUser = redisCache.getCacheObject(redisKey);
//        if (Objects.isNull(loginUser)) {
//            throw new RuntimeException("用户未登录");
//        }
        // 将用户信息存入 SecurityConText
        // UsernamePasswordAuthenticationToken 存储用户名 密码 权限的集合
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
//        // SecurityContextHolder是Spring Security用来存储当前线程安全的认证信息的容器。
//        // 将用户名 密码 权限的集合存入SecurityContextHolder
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);

    }
}
