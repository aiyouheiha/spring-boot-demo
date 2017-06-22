package com.heiha.example.util;

import javax.servlet.http.HttpServletResponse;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/22 15:05<br>
 * <b>Author:</b> heiha<br>
 */
public class ResponseUtil {

    /**
     * Add these response headers to forbid browser cache.
     *
     * @param response
     */
    public static void addNoWebCacheHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
        response.addHeader("Cache-Control", "no-store"); //Firefox
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setDateHeader("Expires", -1);
        response.setDateHeader("max-age", 0);
    }
}
