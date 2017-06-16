package com.heiha.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 13:50<br>
 * <b>Author:</b> heiha<br>
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        String contentType = request.getContentType();
        response.setHeader("Test", "test");
        logger.info("Content Type: {}", contentType);
    }

}
