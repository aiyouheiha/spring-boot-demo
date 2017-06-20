package com.heiha.example.mongo.repository;

import com.heiha.example.mongo.po.Demo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 18:13<br>
 * <b>Author:</b> heiha<br>
 */
public interface DemoRepository extends MongoRepository<Demo, Integer>, QueryDslPredicateExecutor<Demo> {
}
