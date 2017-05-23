package com.heiha.example.mongo.repository;

import com.heiha.example.mongo.po.MongoSamplePO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/23 11:56<br>
 * <b>Author:</b> heiha<br>
 */
public interface MongoSampleRepository {
    List<MongoSamplePO> list();

    MongoSamplePO loadById(String Id);


}
