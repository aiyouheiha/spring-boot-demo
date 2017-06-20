package com.heiha.example.mongo.service.impl;

import com.heiha.example.mongo.po.Demo;
import com.heiha.example.mongo.repository.DemoRepository;
import com.heiha.example.mongo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 19:05<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Override
    public Demo save(Demo demo) {
        return demoRepository.save(demo);
    }

    @Override
    public void removeById(Integer id) {
        demoRepository.delete(id);
    }

    @Override
    public Demo update(Demo demo) {
        return demoRepository.save(demo);
    }

    @Override
    public Demo getById(Integer id) {
        return demoRepository.findOne(id);
    }
}
