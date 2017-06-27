package com.heiha.example.sql.Service.impl;

import com.heiha.example.sql.Service.TbSampleService;
import com.heiha.example.sql.mapper.TbSampleMapper;
import com.heiha.example.sql.po.TbSample;
import com.heiha.example.sql.po.TbSampleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/27 11:42<br>
 * <b>Author:</b> heiha<br>
 */
@Service
public class TbSampleServiceImpl implements TbSampleService {
    @Autowired
    private TbSampleMapper tbSampleMapper;

    @Override
    public TbSample save(TbSample tbSample) {
        // set create time
        tbSample.setCreateTime(new Date());
        tbSampleMapper.insert(tbSample);
        return tbSample;
    }

    @Override
    public void remove(Long id) {
        tbSampleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TbSample change(TbSample tbSample) {
        tbSampleMapper.updateByPrimaryKey(tbSample);
        return tbSample;
    }

    @Override
    public TbSample show(Long id) {
        return tbSampleMapper.selectByPrimaryKey(id);
    }
}
