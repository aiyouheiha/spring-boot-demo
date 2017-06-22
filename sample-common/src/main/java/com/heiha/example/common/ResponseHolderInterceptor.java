package com.heiha.example.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 11:32<br>
 * <b>Author:</b> heiha<br>
 *
 */
public class ResponseHolderInterceptor implements HandlerInterceptor {
    private final static ThreadLocal<HttpServletResponse> responseHolder = new ThreadLocal<>();

    public static HttpServletResponse currentResponse() {
        return responseHolder.get();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        responseHolder.set(response);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        responseHolder.remove();
    }
}
