package com.heiha.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 15:07<br>
 * <b>Author:</b> heiha<br>
 *
 * Deprecated and see {@link ResponseHeaderAddTest}
 *
 * @see com.heiha.example.aop.aspect.NoWebCacheAspect
 * @see ResponseHeaderAddTest
 */
@Deprecated
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoWebCache {
}
