package com.heiha.example.mapper;

import com.alibaba.fastjson.JSON;
import com.heiha.example.SampleMysqlMybatisApplication;
import com.heiha.example.dto.SampleDeleteDTO;
import com.heiha.example.dto.SampleInsertDTO;
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
    }

    private void insert() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO);
        System.out.println("insert: " + sampleMapper.insertSample(insertDTO));
        printJsonObject(insertDTO);
    }

    private void insertList() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        System.out.println("insert list: " + sampleMapper.insertSampleList(list));

        printJsonObject(insertDTO, insertDTO2);
    }

    private void insertList2() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        System.out.println("insert list2: " + sampleMapper.insertSampleList2(list));

        printJsonObject(insertDTO, insertDTO2);
    }

    private void insertList3() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        System.out.println("insert list3: " + sampleMapper.insertSampleList3(list));

        printJsonObject(insertDTO, insertDTO2);
    }

    private void insertList4() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        System.out.println("insert list4: " + sampleMapper.insertSampleList4(list));

        printJsonObject(insertDTO, insertDTO2);
    }

    private void insertList5() {
        SampleInsertDTO insertDTO = SampleTestUtil.newSampleInsertDTO();
        SampleInsertDTO insertDTO2 = SampleTestUtil.newSampleInsertDTO();
        printJsonObject(insertDTO, insertDTO2);

        List<SampleInsertDTO> list = new ArrayList<>();
        list.add(insertDTO);
        list.add(insertDTO2);
        System.out.println("insert list5: " + sampleMapper.insertSampleList5(list));

        printJsonObject(insertDTO, insertDTO2);
    }

    private void delete() {
        SampleDeleteDTO deleteDTO = SampleTestUtil.newSampleDeleteDTO();
        printJsonObject(deleteDTO);
        System.out.println("delete: " + sampleMapper.deleteSample(deleteDTO));
        printJsonObject(deleteDTO);

    }

    private void printJsonObject(Object... objects) {
        for (Object object : objects) {
            System.out.println(JSON.toJSONString(object));
        }
    }

}