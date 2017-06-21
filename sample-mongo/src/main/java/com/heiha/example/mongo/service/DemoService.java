package com.heiha.example.mongo.service;

import com.heiha.example.mongo.po.Demo;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 18:55<br>
 * <b>Author:</b> heiha<br>
 */
public interface DemoService {
    Demo save(Demo demo);
    void removeById(String id);
    Demo update(Demo demo);
    List<Demo> getById(String id);
}
