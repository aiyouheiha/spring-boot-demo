package com.heiha.example.common;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 11:39<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class ResponseHolderFilter implements Filter{
    private final static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public static HttpServletResponse currentResponse() {
        return responseHolder.get();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        responseHolder.set((HttpServletResponse)servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);
        responseHolder.remove();
    }

    @Override
    public void destroy() {

    }
}
