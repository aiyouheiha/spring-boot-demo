package com.heiha.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/17 17:25<br>
 * <b>Author:</b> heiha<br>
 *
 * @see org.springframework.boot.autoconfigure.mongo.MongoProperties
 * @see org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
 */
@Component
public class MongoHelper {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void use() {
        System.out.println(mongoTemplate.getCollectionNames());
    }

}
