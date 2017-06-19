package com.heiha.example.aop;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/19 14:33<br>
 * <b>Author:</b> heiha<br>
 */
public class AdditionalResponseHeaderAspect {

    @Pointcut("@annotation(com.heiha.example.aop.annotation.AdditionalResponseHeader)")
    public void cut() {}

    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        ServletWebRequest webRequest = new ServletWebRequest(request);
        HttpServletResponse response = webRequest.getResponse();
        response.addHeader("Demo-Test", "only a test");

        Object result = joinPoint.proceed();
        return result;
    }
}
