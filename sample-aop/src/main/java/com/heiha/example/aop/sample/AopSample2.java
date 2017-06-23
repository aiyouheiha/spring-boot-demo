package com.heiha.example.aop.sample;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 9:34<br>
 * <b>Author:</b> heiha<br>
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopSample2 {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}
