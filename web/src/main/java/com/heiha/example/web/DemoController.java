package com.heiha.example.web;

import com.heiha.example.aop.annotation.AdditionalResponseHeader;
import com.heiha.example.aop.annotation.NoWebCache;
import com.heiha.example.mongo.po.Demo;
import com.heiha.example.mongo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 13:49<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {
    @Autowired
    private DemoService demoService;

    @AdditionalResponseHeader
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String demo(Integer id) {
        return "It is " + id;
    }


    @NoWebCache
    @RequestMapping(path = "/toDemo", method = RequestMethod.GET)
    public String toDemo() {
        return "/demo";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Demo getById(@PathVariable("id") Integer id) {
        return demoService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Demo save(@RequestBody Demo demo) {
        return demoService.save(demo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Demo update(@RequestBody Demo demo) {
        return demoService.update(demo);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeById(@PathVariable("id") Integer id) {
        demoService.removeById(id);
    }
}
