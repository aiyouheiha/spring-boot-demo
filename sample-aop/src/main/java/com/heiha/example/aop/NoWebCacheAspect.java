package com.heiha.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 15:11<br>
 * <b>Author:</b> heiha<br>
 */
@Component
@Aspect
public class NoWebCacheAspect implements Filter{

    private final static Logger LOGGER = LoggerFactory.getLogger(NoWebCacheAspect.class);

    /**
     * 之前未定义为static类型，<br>
     * 可能存在同一线程下，Filter和Aspect因为分别对应一个各自的bean实例，<br>
     * 导致set和get操作的并非同一个ThreadLocal对象
     * <p>
     *     主要是针对spring3，因为设置
     *     <mvc:annotation-driven />
     *     <aop:aspectj-autoproxy/>
     *     后，aop可以自动加载，但是Filter或者Interceptor依旧不行，需要配置文件中配置为bean
     *     测试结果spring3中set和get对应的并非同一个ThreadLocal
     *     但是在本项目中，spring4，貌似对应的是一个bean实例，即使非static，依旧可以
     *     在ThreadLocal正常的存放response对象
     *      不过讲道理，需要加上static，以对应其功能需求
     * </p>
     *
     */
    private final static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

    public HttpServletResponse getResponse() {
        return responseThreadLocal.get();
    }

    public void setResponse(HttpServletResponse response) {
        responseThreadLocal.set(response);
    }


    @Pointcut("@annotation(com.heiha.example.aop.annotation.NoWebCache)")
    public void pointCut() {}

    @Around("pointCut()")
    public Object noWebCache(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        LOGGER.info("prepare to add no cache response header");

        HttpServletResponse response = this.responseThreadLocal.get();
        if (response == null) {
            LOGGER.info("set response header, response is null");
        } else {
            response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
            response.addHeader("Cache-Control", "no-store"); //Firefox
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", -1);
            response.setDateHeader("max-age", 0);
            LOGGER.info("set response header finished");
        }

        return result;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        LOGGER.info("set response, response is {}", response);
        this.responseThreadLocal.set(response);
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("Remove useless response in ThreadLocal");
        this.responseThreadLocal.remove();
        if (this.responseThreadLocal.get() == null) {
            LOGGER.info("After remove, hold null");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {

    }
}
