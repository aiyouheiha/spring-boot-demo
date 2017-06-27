package com.heiha.example.sql.Service;

import com.heiha.example.sql.po.TbSample;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/27 11:37<br>
 * <b>Author:</b> heiha<br>
 */
public interface TbSampleService {
    TbSample save(TbSample tbSample);
    void remove(Long id);
    TbSample change(TbSample tbSample);
    TbSample show(Long id);
}
