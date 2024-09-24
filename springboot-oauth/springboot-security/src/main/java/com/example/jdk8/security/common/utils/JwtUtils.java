package com.rawchen.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

/**
 * @Description: JWT工具类
 * @Date: 2024-09-24
 */
@Component  // 表明这个类是一个Spring组件，可以被Spring框架自动扫描和装配
public class JwtUtils {
    private static long expireTime;  // token的过期时间
    private static String secretKey; // 用于签名和解析token的密钥

    @Value("${token.secretKey}")  // 从配置文件中读取secretKey的值
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Value("${token.expireTime}")  // 从配置文件中读取expireTime的值
    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 判断token是否存在
     *
     * @param token 需要判断的token
     * @return 返回token是否存在且不为空
     */
    public static boolean judgeTokenIsExist(String token) {
        return token != null && !"".equals(token) && !"null".equals(token);
    }

    /**
     * 生成token
     *
     * @param subject 存放在token中的主体信息（如用户名）
     * @return 返回生成的JWT字符串
     */
    public static String generateToken(String subject) {
        String jwt = Jwts.builder()
                .setSubject(subject)  // 设置token的主体
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))  // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secretKey)  // 设置签名算法和密钥
                .compact();
        return jwt;
    }

    /**
     * 生成带角色权限的token
     *
     * @param subject      存放在token中的主体信息（如用户名）
     * @param authorities  用户的角色权限集合
     * @return 返回生成的带有角色权限的JWT字符串
     */
    public static String generateToken(String subject, Collection<? extends GrantedAuthority> authorities) {
        StringBuilder sb = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            sb.append(authority.getAuthority()).append(",");  // 拼接用户的所有角色权限
        }
        String jwt = Jwts.builder()
                .setSubject(subject)  // 设置token的主体
                .claim("authorities", sb.toString())  // 在token中添加角色权限信息
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))  // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secretKey)  // 设置签名算法和密钥
                .compact();
        return jwt;
    }

    /**
     * 生成自定义过期时间token
     *
     * @param subject     存放在token中的主体信息（如用户名）
     * @param expireTime  自定义的过期时间
     * @return 返回生成的JWT字符串
     */
    public static String generateToken(String subject, long expireTime) {
        String jwt = Jwts.builder()
                .setSubject(subject)  // 设置token的主体
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))  // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secretKey)  // 设置签名算法和密钥
                .compact();
        return jwt;
    }

    /**
     * 获取tokenBody同时校验token是否有效（无效则会抛出异常）
     *
     * @param token 需要解析的token
     * @return 返回token中的Claims对象，包含token的所有声明
     */
    public static Claims getTokenBody(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey)  // 设置解析时的密钥
                .parseClaimsJws(token.replace("Bearer", ""))  // 解析token
                .getBody();  // 获取token中的Claims对象
        return claims;
    }
}

