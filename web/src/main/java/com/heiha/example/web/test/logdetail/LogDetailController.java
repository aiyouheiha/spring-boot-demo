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
    /**
     * As {@link LogTest#test2} is Boolean, param test should be
     * <br> ...&test2=true&... or ...&test2=false&...
     * <br> or ...&test2=&... or without send param test2
     * <br> <b>If send ...&test2=null&...
     * Actually, it was sending a String "null", but a real null, and will get an error</b>
     *
     * @param s
     * @param i
     * @param logTest
     * @param list
     * @return
     */
    @Args
    @RequestMapping(method = RequestMethod.POST)
    public String log(@RequestParam(required = false) String s, @RequestParam(required = false) Integer i, LogTest logTest, @RequestBody List<String> list) {
        return "over";
    }
}
