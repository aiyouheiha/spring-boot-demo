package com.heiha.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/19 10:48<br>
 * <b>Author:</b> heiha<br>
 *
 * This is only a test annotation. <br>
 * Deprecated and see {@link ResponseHeaderAddTest}
 *
 * @see com.heiha.example.aop.aspect.AdditionalResponseHeaderAspect
 * @see ResponseHeaderAddTest
 */
@Deprecated
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdditionalResponseHeader {
}
