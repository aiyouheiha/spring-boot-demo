package com.heiha.example.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 14:14<br>
 * <b>Author:</b> heiha<br>
 */
@Configuration
public class ResponseHolderInterceptorAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResponseHolderInterceptor()).addPathPatterns("/test/response/header/interceptor");
        super.addInterceptors(registry);
    }
}
