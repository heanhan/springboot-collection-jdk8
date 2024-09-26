package com.example.jdk8.simple.config;

import com.example.jdk8.simple.security.EntryPointUnauthorizedHandler;
import com.example.jdk8.simple.security.PerThreadRequestFilter;
import com.example.jdk8.simple.security.RequestAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhaojh
 * @description: security的配置
 * @date 2024-09-24
 */
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 作用：保证在单个请求线程中每个请求仅调用一次 的拦截器
     * 自定义的Jwt Token校验过滤器
     */
    @Resource
    private PerThreadRequestFilter perThreadRequestFilter;

    @Resource
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    //用户认证通过 但是没有权限的自定义处理器
    @Resource
    private RequestAccessDeniedHandler requestAccessDeniedHandler;

    /**
     * 密码加解密工具bean
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder encoderPassword() {
        return new BCryptPasswordEncoder();
    }


    /** AuthenticationManager 认证管理器 */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().disable()//默认表单
            // 因为是 前后端分离 要关闭 csrf()
            .csrf().disable()
            // 不通过 session 获取 SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            // 登录接口公开访问
            .antMatchers("/auth/login","/auth/logout","/auth/registerUser").anonymous()
            // 除上面公开的接口外，所有的请求都需要鉴定认证
            .anyRequest().authenticated()
            .and()
            // 添加 过滤器
        // 在 SecurityConfig 内将 token 校验过滤器添加到过滤器链内
           .addFilterBefore(perThreadRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // 异常处理
        http.exceptionHandling().authenticationEntryPoint(entryPointUnauthorizedHandler).accessDeniedHandler(requestAccessDeniedHandler);
        // 允许跨域
        http.cors();
    }

    /**
     * 配置哪些请求不拦截
     * 排除swagger相关请求
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/favicon.ico",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/v2/**",
                        "/swagger-ui.html/**",
                        "/doc.html");
    }


}
