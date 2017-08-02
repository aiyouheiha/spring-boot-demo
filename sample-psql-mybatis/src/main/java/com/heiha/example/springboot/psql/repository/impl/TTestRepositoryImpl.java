package com.heiha.example.springboot.psql.repository.impl;

import com.heiha.example.springboot.psql.mapper.TTestMapper;
import com.heiha.example.springboot.psql.po.TTest;
import com.heiha.example.springboot.psql.po.TTestExample;
import com.heiha.example.springboot.psql.repository.TTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/8/2 17:40<br>
 * <b>Author:</b> heiha<br>
 */
@Repository
public class TTestRepositoryImpl implements TTestRepository {
    @Autowired
    private TTestMapper tTestMapper;

    @Override
    public Integer save(TTest tTest) {
        return tTestMapper.insert(tTest);
    }

    @Override
    public Integer remove(TTest tTest) {
        TTestExample example = new TTestExample();
        TTestExample.Criteria criteria = example.createCriteria();
        if (tTest.getId() != null) {
            criteria.andIdEqualTo(tTest.getId());
        }
        if (tTest.getName() != null) {
            criteria.andNameLike("%" + tTest.getName() + "%");
        }

        return tTestMapper.deleteByExample(example);
    }

    @Override
    public Integer update(TTest tTest) {
        TTestExample example = new TTestExample();
        TTestExample.Criteria criteria = example.createCriteria();
        if (tTest.getId() != null) {
            criteria.andIdEqualTo(tTest.getId());
        }
        return tTestMapper.updateByExample(tTest, example);
    }

    @Override
    public List<TTest> get(TTest tTest) {
        TTestExample example = new TTestExample();
        TTestExample.Criteria criteria = example.createCriteria();
        if (tTest.getId() != null) {
            criteria.andIdEqualTo(tTest.getId());
        }
        if (tTest.getName() != null) {
            criteria.andNameLike("%" + tTest.getName() + "%");
        }
        return tTestMapper.selectByExample(example);
    }
}
