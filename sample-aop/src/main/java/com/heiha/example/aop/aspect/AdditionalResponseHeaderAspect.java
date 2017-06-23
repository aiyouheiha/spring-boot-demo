package com.heiha.example.aop.aspect;

import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
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
 *
 * This is only a test aspect. <br>
 * Deprecated and see {@link ResponseHeaderAddTestAspect}
 *
 * @see com.heiha.example.aop.annotation.AdditionalResponseHeader
 * @see ResponseHeaderAddTestAspect
 */
@Deprecated
@Aspect
@Component
public class AdditionalResponseHeaderAspect {

//    @Pointcut("execution(* com.heiha.example.web.*.*(..)) && @annotation(com.heiha.example.aop.annotation.AdditionalResponseHeader)")
    @Pointcut("@annotation(com.heiha.example.aop.annotation.AdditionalResponseHeader)")
    public void cut() {}

    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 这种方式spring3不支持，当前4.3.7是支持的
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();

        response.addHeader("Demo-Test", "only a test");

        Object result = joinPoint.proceed();
        return result;
    }
}
