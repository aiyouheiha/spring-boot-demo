package com.heiha.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <b>Project:</b> spring-boot-demo
 * <b>Date:</b> 2017-08-07 23:33
 * <b>Author:</b> heiha
 */
@Aspect
@Component
public class DemoAnnotationAspect {
    @Around("@annotation(com.heiha.example.aop.annotation.DemoAnnotation)")
    public Object around(ProceedingJoinPoint j) throws Throwable {
        try {
            System.out.println(Thread.currentThread().getName().concat( "DemoAnnotation start"));
            return j.proceed();
        } finally {
            System.out.println(Thread.currentThread().getName().concat( "DemoAnnotation end"));
        }
    }
}
