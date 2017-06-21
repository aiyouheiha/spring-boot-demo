package com.heiha.example.mongo.service.impl;

import com.heiha.example.mongo.po.Demo;
import com.heiha.example.mongo.service.DemoService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 19:05<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Demo save(Demo demo) {
        mongoTemplate.save(demo);
        return demo;
    }

    @Override
    public void removeById(String id) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("id").is(id);
        query.addCriteria(criteria);
        WriteResult result = mongoTemplate.remove(query, Demo.class);
        System.out.println(result.toString());
    }

    @Override
    public Demo update(Demo demo) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("id").is(demo.getId());
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("name", demo.getName());
        update.set("wuXingType", demo.getWuXingType());
        update.set("note", demo.getNote());

        WriteResult result = mongoTemplate.updateFirst(query, update, Demo.class);
        System.out.println(result.toString());
        return demo;
    }

    @Override
    public List<Demo> getById(String id) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("id").is(id);
        query.addCriteria(criteria);

        return mongoTemplate.find(query, Demo.class);
    }
}
