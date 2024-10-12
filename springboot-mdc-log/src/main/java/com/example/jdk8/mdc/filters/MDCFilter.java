package com.example.jdk8.mdc.filters;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


/**
 * @author zhaojh
 * @description: TODO
 * @date 2024-10-12
 */

@Component
public class MDCFilter implements Filter {
    private static final String REQUEST_ID_HEADER = "requestId";
    private static final String REQUEST_ID = "requestId";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestId = request.getHeader(REQUEST_ID_HEADER);
        String requestIdMDC = Optional.ofNullable(requestId).orElseGet(() -> UUID.randomUUID().toString());
        response.setHeader(REQUEST_ID_HEADER, requestIdMDC);
        MDC.put(REQUEST_ID, requestIdMDC);
        try {
            filterChain.doFilter(request,response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {
    }
}
