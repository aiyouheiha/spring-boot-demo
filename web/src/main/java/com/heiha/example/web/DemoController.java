package com.heiha.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 13:49<br>
 * <b>Author:</b> heiha<br>
 */
@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String demo(Integer id) {
        return "It is " + id;
    }


    @RequestMapping(path = "/toDemo", method = RequestMethod.GET)
    public String toDemo() {
        return "redirect:/demo";
    }
}
