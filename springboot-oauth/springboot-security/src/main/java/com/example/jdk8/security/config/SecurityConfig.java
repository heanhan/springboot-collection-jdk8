package com.example.jdk8.security.config;

import com.example.jdk8.security.security.EntryPointUnauthorizedHandler;
import com.example.jdk8.security.security.PerThreadRequestFilter;
import com.example.jdk8.security.security.RequestAccessDeniedHandler;
import com.example.jdk8.security.security.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
     */
    @Resource
    private PerThreadRequestFilter perThreadRequestFilter;

    @Resource
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    //用户认证通过 但是没有权限的自定义处理器
    @Resource
    private RequestAccessDeniedHandler requestAccessDeniedHandler;

    // 自定义的Jwt Token校验过滤器
    @Resource
    public TokenAuthenticationFilter tokenAuthenticationFilter;

    /**
     * 密码加解密工具bean
     * @return
     */
    @Bean
    public BCryptPasswordEncoder encoderPassword(){
        return new BCryptPasswordEncoder();
    }

    /**
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //禁用表单登录，因为前后端分离不使用自带的
        http.formLogin().disable()
                .authorizeRequests()
                .antMatchers("","")
                .permitAll()
                //某个开头的路径只能某些权限访问
                .antMatchers("/admmin").hasRole("ADMIN")
                // anyRequest() 所有请求   authenticated() 必须被认证
                .anyRequest()
                .authenticated()
                //处理异常情况
                .and()
                .exceptionHandling()
                //处理 认证未通过，不允许访问的异常处理器
                .authenticationEntryPoint(entryPointUnauthorizedHandler)
                //认证通过但是没有权限  的处理器
                .accessDeniedHandler(requestAccessDeniedHandler)
                //前段端分离 建议采用token 无状态的方式 因此要禁用 session
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //将token 校验过滤器配置到过滤器链中来，否则不生效，放到UsernamePasswordAuthenticationFilter【默认的用户密码认证校验】之前
                .and()
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                //关闭csrf 防止跨站伪造
                .cors().disable();

    }



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
    }


}
