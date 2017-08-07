package com.heiha.example.aop.sample;

import com.alibaba.fastjson.JSON;
import com.heiha.example.aop.sample.AopSample2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 9:17<br>
 * <b>Author:</b> heiha<br>
 *
 */
@Aspect
@Component
public class SampleAspect {

    @Pointcut("execution(* com.heiha.example.aop.sample.DoSomething.*(..)) && @annotation(com.heiha.example.aop.sample.AopSample)")
    public void pointCut() {}

    @Before("pointCut()")
    public void before(JoinPoint j) {
        System.out.println(Thread.currentThread().getName().concat(" aop start"));
        showLocationInfo(j);
        showArgs(j);
        System.out.println(Thread.currentThread().getName().concat(" aop end"));
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint j, Object result) {
        showResult(j, result);
    }

    @Around("execution(* com.heiha.example.aop.sample.DoSomething.*(..)) && @annotation(annotation)")
    public Object around(ProceedingJoinPoint pj, AopSample2 annotation) throws Throwable {
        System.out.println("Annotation AopSample2 Value: " + annotation.value());
        System.out.println("Annotation AopSample2 Name: " + annotation.name());

        showLocationInfo(pj);
        showArgs(pj);

        Object result =  pj.proceed();

        showResult(pj, result);

        return result;
    }

    /**
     * If wanna deal with args, use this way.
     * <p>
     * Or using j.proceed() with no params is enough, even if method have, like {@code around()}
     *
     * @param j
     * @return
     * @throws Throwable
     */
    @Around("@annotation(SampleAnnotation)")
    public Object around3(ProceedingJoinPoint j) throws Throwable {
        Object[] args = j.getArgs();
        args[0] = args[0] + ": add in aspect";
        return j.proceed(args);
    }

    private void showLocationInfo(JoinPoint j) {
        Signature s = j.getSignature();
        String className = s.getDeclaringTypeName();
        String methodName = s.getName();

        System.out.println("class name: " + className);
        System.out.println("method name: " + methodName);
    }

    private void showArgs(JoinPoint j) {
        Object[] args = j.getArgs();
        for (int i = 0; i < args.length; i ++) {
            String name = null;
            String value = null;
            if (args[i] != null) {
                name = "arg" + i + "-[" + args[i].getClass().getTypeName() + "]";
                value = JSON.toJSONString(args[i]);
            }
            System.out.println(name + ": " + value);
        }
    }

    private void showResult(JoinPoint j, Object result) {
        showLocationInfo(j);
        System.out.println("result: " + JSON.toJSONString(result));
    }

}
