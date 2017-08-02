package com.heiha.example.springboot.psql.repository;

import com.heiha.example.springboot.psql.po.TTest;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/2 17:33<br>
 * <b>Author:</b> heiha<br>
 */
public interface TTestRepository {
    Integer save(TTest tTest);
    Integer remove(TTest tTest);
    Integer update(TTest tTest);
    List<TTest> get(TTest tTest);
}
