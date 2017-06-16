package com.heiha.example.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 15:27<br>
 * <b>Author:</b> heiha<br>
 *
 * @see com.heiha.example.web.DemoHandlerInterceptor
 */
@Configuration
public class DemoWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new DemoHandlerInterceptor()).addPathPatterns("/demo/test");
        super.addInterceptors(registry);
    }
}
