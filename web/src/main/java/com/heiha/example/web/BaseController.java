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
 *
 * Inherit this abstract class can help other class to use request and response. <br>
 * <p>
 * <b>BUT</b> due to I have not found a fine way to remove request or response <br>
 * in <code>requestThreadLocal</code> and <code>responseThreadLocal</code> <br>
 * Maybe its not safe, so add <b>Deprecated</b>
 * </p>
 * <p>
 * <b>ALSO</b> Only use {@link ModelAttribute} to handle request and response is ok. <br>
 * Such as add united headers just only in method with {@link ModelAttribute} annotation
 * </p>
 */
@Deprecated
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static ThreadLocal<HttpServletRequest> requestThreadLocal;
    protected static ThreadLocal<HttpServletResponse> responseThreadLocal;

    @ModelAttribute
    private void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response) {
        requestThreadLocal.set(request);
        responseThreadLocal.set(response);
    }
}
