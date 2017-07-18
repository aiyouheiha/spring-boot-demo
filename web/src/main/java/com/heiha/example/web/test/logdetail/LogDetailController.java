package com.heiha.example.web.test.logdetail;

import org.springframework.web.bind.annotation.*;

import com.heiha.example.aop.annotation.Args;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/18 15:43<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/test/20170718/logdetail")
public class LogDetailController {
    @Args
    @RequestMapping(method = RequestMethod.POST)
    public String log(@RequestParam(required = false) String s, @RequestParam(required = false) Integer i, @RequestBody List<String> list) {
        return "over";
    }
}
