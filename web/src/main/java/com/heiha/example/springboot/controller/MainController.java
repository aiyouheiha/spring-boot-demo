package com.heiha.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/2 11:53<br>
 * <b>Author:</b> heiha<br>
 */
@Controller
public class MainController {
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "/hello";
    }
}
