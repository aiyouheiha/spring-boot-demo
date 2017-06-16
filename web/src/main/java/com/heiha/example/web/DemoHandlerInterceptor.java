package com.heiha.example.web;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 14:59<br>
 * <b>Author:</b> heiha<br>
 *
 * <a href="http://blog.csdn.net/linxingliang/article/details/52069495">Spring Boot拦截器HandlerInterceptor</a>
 * <p>
 * {@link HandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)} <br>
 * 在请求处理之前进行调用（Controller方法调用之前），返回true继续，返回false中断
 * <p>
 * {@link HandlerInterceptor#postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)} <br>
 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
 * <p>
 * {@link HandlerInterceptor#afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception)} <br>
 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
 * <p>
 * 只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的
 *
 * @see com.heiha.example.web.DemoWebMvcConfigurerAdapter
 */
public class DemoHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        String id = httpServletRequest.getParameter("id");
        if (id != null && !id.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
