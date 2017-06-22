package com.heiha.example.web;

import com.heiha.example.aop.annotation.ResponseGetMethod;
import com.heiha.example.aop.annotation.ResponseHeaderAddTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 14:02<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/test/response/header")
public class ResponseHeaderAddTestController {

    @ResponseHeaderAddTest(method = ResponseGetMethod.FILTER)
    @RequestMapping(path = "/filter", method = RequestMethod.GET)
    public String testFilter() {
        return "Get response by Filter";
    }

    @ResponseHeaderAddTest(method = ResponseGetMethod.INTERCEPTOR)
    @RequestMapping(path = "/interceptor", method = RequestMethod.GET)
    public String testInterceptor() {
        return "Get response by Interceptor";
    }

    @ResponseHeaderAddTest(method = ResponseGetMethod.REQUEST_CONTEXT_HOLDER)
    @RequestMapping(path = "/requestContextHolder", method = RequestMethod.GET)
    public String testRequestContextHolder() {
        return "Get response by RequestContextHolder";
    }
}
