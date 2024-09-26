package com.example.jdk8.jwt.config;

import com.example.jdk8.jwt.security.EntryPointUnauthorizedHandler;
import com.example.jdk8.jwt.security.PerThreadRequestFilter;
import com.example.jdk8.jwt.security.RequestAccessDeniedHandler;
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


    /**
     * @param http the {@link HttpSecurity} to modify
     * @throws Exception
     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //禁用表单登录，因为前后端分离不使用自带的
//        http.formLogin().disable().authorizeRequests().antMatchers("/api/auth/login", "/api/auth/logout").permitAll()
//                //某个开头的路径只能某些权限访问
//                .antMatchers("/admmin").hasRole("ADMIN")
//                // anyRequest() 所有请求   authenticated() 必须被认证
//                .anyRequest().authenticated()
//                //处理异常情况
//                .and().exceptionHandling()
//                //处理 认证未通过，不允许访问的异常处理器
//                .authenticationEntryPoint(entryPointUnauthorizedHandler)
//                //认证通过但是没有权限  的处理器
//                .accessDeniedHandler(requestAccessDeniedHandler)
//                //前段端分离 建议采用token 无状态的方式 因此要禁用 session
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                //将token 校验过滤器配置到过滤器链中来，否则不生效，放到UsernamePasswordAuthenticationFilter【默认的用户密码认证校验】之前
//                .and().addFilterBefore(perThreadRequestFilter, UsernamePasswordAuthenticationFilter.class)
//                //关闭csrf 防止跨站伪造
//                .cors().disable()
//                //允许跨域
//                .cors();
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
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
                .addFilterBefore(perThreadRequestFilter, UsernamePasswordAuthenticationFilter.class);

        // 在 SecurityConfig 内将 token 校验过滤器添加到过滤器链内
        http.addFilterBefore(perThreadRequestFilter, UsernamePasswordAuthenticationFilter.class);
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
