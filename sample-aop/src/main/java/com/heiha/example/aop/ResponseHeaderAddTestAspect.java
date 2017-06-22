package com.heiha.example.aop;

import com.heiha.example.aop.annotation.ResponseGetMethod;
import com.heiha.example.aop.annotation.ResponseHeaderAddTest;
import com.heiha.example.common.ResponseHolderFilter;
import com.heiha.example.common.ResponseHolderInterceptor;
import com.heiha.example.util.ResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

import static javaslang.API.Match;
import static javaslang.API.Case;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 11:48<br>
 * <b>Author:</b> heiha<br>
 */
@Aspect
@Component
public class ResponseHeaderAddTestAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseHeaderAddTestAspect.class);

    @Around("@annotation(annotation)")
    public Object addHeader(ProceedingJoinPoint joinPoint, ResponseHeaderAddTest annotation) throws Throwable {
        HttpServletResponse response = Match(annotation.method()).of(
                Case(ResponseGetMethod.FILTER, ResponseHolderFilter.currentResponse()),
                Case(ResponseGetMethod.INTERCEPTOR, ResponseHolderInterceptor.currentResponse()),
                Case(ResponseGetMethod.REQUEST_CONTEXT_HOLDER,
                        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse())
        );

        if (response == null) {
            LOGGER.info("Response is null, add header failed");
        } else {
            response.addHeader("Header-Add-Test", "This is a test header");
            addNoWebCacheHeader(response);
            LOGGER.info("Add \"test\" response header success");
        }

        return joinPoint.proceed();
    }

    private void addNoWebCacheHeader(HttpServletResponse response) {
        ResponseUtil.addNoWebCacheHeader(response);
        LOGGER.info("Add \"no web cache\" response header success");
    }
}
