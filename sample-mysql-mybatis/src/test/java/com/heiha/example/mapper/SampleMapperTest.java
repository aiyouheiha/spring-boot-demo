package com.heiha.example.mapper;

import com.alibaba.fastjson.JSON;
import com.heiha.example.SampleMysqlMybatisApplication;
import com.heiha.example.dto.SampleDeleteDTO;
import com.heiha.example.dto.SampleInsertDTO;
import com.heiha.example.dto.SampleUpdateDTO;
import com.heiha.example.dto.SampleUpdateListDTO;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 16:25<br>
 * <b>Author:</b> heiha<br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMysqlMybatisApplication.class)
@MapperScan("com.heiha.example.mapper")
public class SampleMapperTest {

    @Autowired
    private SampleMapper sampleMapper;

    @Test
    public void sqlOperations() {
        insert();
        insertList();
        insertList2();
        insertList3();
        insertList4();
        insertList5();
        delete();
        update();
        updateList();
        updateList2();
        get();
        list();
    }

    private void insert() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insert", insertDTO);
        printJsonObject("insert", sampleMapper.insertSample(insertDTO));
        printJsonObject("insert", insertDTO);
    }

    private void insertList() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insertList", insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        printJsonObject("insertList", sampleMapper.insertSampleList(list));

        printJsonObject("insertList", insertDTO, insertDTO2);
    }

    private void insertList2() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insertList2", insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        printJsonObject("insertList2", sampleMapper.insertSampleList2(list));

        printJsonObject("insertList2", insertDTO, insertDTO2);
    }

    private void insertList3() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insertList3", insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        printJsonObject("insertList3", sampleMapper.insertSampleList3(list));

        printJsonObject("insertList3", insertDTO, insertDTO2);
    }

    private void insertList4() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insertList4", insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        printJsonObject("insertList4", sampleMapper.insertSampleList4(list));

        printJsonObject("insertList4", insertDTO, insertDTO2);
    }

    private void insertList5() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject("insertList5", insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        printJsonObject("insertList5", sampleMapper.insertSampleList5(list));

        printJsonObject("insertList5", insertDTO, insertDTO2);
    }

    private void delete() {
        SampleDeleteDTO deleteDTO = SampleTestUtil.newSampleDeleteDTO();
        printJsonObject("delete", deleteDTO);
        printJsonObject("delete", sampleMapper.deleteSample(deleteDTO));
        printJsonObject("delete", deleteDTO);

    }

    private void update() {
        SampleUpdateDTO updateDTO = SampleTestUtil.newSampleUpdateDTO();
        printJsonObject("update", updateDTO);
        printJsonObject("update", sampleMapper.updateSample(updateDTO));
        printJsonObject("update", updateDTO);

    }

    private void updateList() {
        SampleUpdateDTO updateDTO = SampleTestUtil.newSampleUpdateDTO();
        SampleUpdateDTO updateDTO2 = SampleTestUtil.newSampleUpdateDTO();
        printJsonObject("updateList", updateDTO, updateDTO2);

        List<SampleUpdateDTO> list = new ArrayList<>();
        list.add(updateDTO);
        list.add(updateDTO2);

        printJsonObject("updateList", sampleMapper.updateSampleList(list));
        printJsonObject("updateList", updateDTO, updateDTO2);

    }

    private void updateList2() {
        SampleUpdateListDTO updateListDTO = SampleTestUtil.newSampleUpdateListDTO();
        printJsonObject("updateList2", updateListDTO);
        printJsonObject("updateList2", sampleMapper.updateSampleList2(updateListDTO));
        printJsonObject("updateList2", updateListDTO);

    }

    public void get() {
        printJsonObject("get", sampleMapper.getSampleById(SampleTestUtil.randomId()));
    }

    public void list() {
        printJsonObject("list", sampleMapper.listSample());
    }

    private void printJsonObject(String note, Object... objects) {
        for (Object object : objects) {
            System.out.println(note + " : " + JSON.toJSONString(object));
        }
    }

}