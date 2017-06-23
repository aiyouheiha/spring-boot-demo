package com.heiha.example.aop.annotation;

import com.heiha.example.aop.aspect.ResponseGetMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 11:24<br>
 * <b>Author:</b> heiha<br>
 *
 * @see com.heiha.example.aop.aspect.ResponseHeaderAddTestAspect
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseHeaderAddTest {
    ResponseGetMethod method() default ResponseGetMethod.REQUEST_CONTEXT_HOLDER;
}
