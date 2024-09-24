package com.example.jdk8.security.security;

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

//    /**
//     * @param defaultFilterProcessesUrl the default value for <tt>filterProcessesUrl</tt>.
//     */
//    protected EntryPointUnauthorizedHandler(String defaultFilterProcessesUrl) {
//        super(defaultFilterProcessesUrl);
//    }

    /**
     * 执行实际的身份验证。
     * 实施应该执行以下操作之一：
     * 返回已认证用户的已填充认证令牌，表示认证成功
     * 返回 null，表示身份验证过程仍在进行中。在返回之前，实现应该执行完成该过程所需的任何其他工作。
     * 如果身份验证过程失败，则抛出AuthenticationException
     * @param request  从中提取参数并执行身份验证的请求
     * @param response 如果实现必须执行重定向作为多阶段身份验证过程（例如 OpenID）的一部分，则可能需要该响应
     * @return 经过身份验证的用户令牌，如果身份验证不完整，则为 null。
     * @throws AuthenticationException 认证失败抛出的异常
     */
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        return null;
//    }


}
