package com.heiha.example.web;

import com.heiha.example.sql.Service.TbSampleService;
import com.heiha.example.sql.po.TbSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/27 14:26<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping(path = "/test/sample")
public class TbSampleController {
    @Autowired
    private TbSampleService tbSampleService;

    @RequestMapping(method = RequestMethod.POST)
    public TbSample save(@RequestBody TbSample tbSample) {
        return tbSampleService.save(tbSample);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        tbSampleService.remove(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public TbSample change(TbSample tbSample) {
        return tbSampleService.change(tbSample);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TbSample show(@PathVariable("id") Long id) {
        return tbSampleService.show(id);
    }
}
