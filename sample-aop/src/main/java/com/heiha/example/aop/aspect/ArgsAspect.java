package com.heiha.example.aop.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/17 19:13<br>
 * <b>Author:</b> heiha<br>
 *
 * @see com.heiha.example.aop.annotation.Args
 */
@Aspect
@Component
public class ArgsAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ArgsAspect.class);

    @Around("execution(* *.*(..)) && @annotation(com.heiha.example.aop.annotation.Args)")
    public Object logArgs(ProceedingJoinPoint j) throws Throwable {
        Object[] args = j.getArgs();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            stringBuffer.append("Args ").append(i).append("# ").append(JSON.toJSONString(args[i])).append(" | ");
        }
        LOGGER.info(stringBuffer.toString());
        return j.proceed();
    }
}
