package com.heiha.example.mapper;

import com.heiha.example.dto.SampleDeleteDTO;
import com.heiha.example.dto.SampleInsertDTO;
import com.heiha.example.dto.SampleUpdateDTO;
import com.heiha.example.dto.SampleUpdateListDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 18:06<br>
 * <b>Author:</b> heiha<br>
 */
public class SampleTestUtil {
    private static Random random = new Random();

    public static SampleInsertDTO newSampleInsertDTO() {
        SampleInsertDTO sampleInsertDTO = new SampleInsertDTO();
        sampleInsertDTO.setCreateUserId("User_" + random.nextInt(4));
        sampleInsertDTO.setVersion(String.valueOf(random.nextInt(4)));
        return sampleInsertDTO;
    }

    public static SampleDeleteDTO newSampleDeleteDTO() {
        SampleDeleteDTO sampleDeleteDTO = new SampleDeleteDTO();
        sampleDeleteDTO.setId(null);
        sampleDeleteDTO.setCreateUserId("3");
        sampleDeleteDTO.setUpdateUserId(null);
        return sampleDeleteDTO;
    }

    public static SampleUpdateDTO newSampleUpdateDTO() {
        SampleUpdateDTO sampleUpdateDTO = new SampleUpdateDTO();
        sampleUpdateDTO.setId(Long.valueOf(random.nextInt(100)));
        sampleUpdateDTO.setVersion(String.valueOf(random.nextInt(100)));
        return sampleUpdateDTO;
    }

    public static SampleUpdateListDTO newSampleUpdateListDTO() {
        SampleUpdateListDTO sampleUpdateListDTO = new SampleUpdateListDTO();
        sampleUpdateListDTO.setUpdateUserId("User_" + random.nextInt(10));
        List<SampleUpdateDTO> list = new ArrayList<>();
        list.add(newSampleUpdateDTO());
        list.add(newSampleUpdateDTO());
        sampleUpdateListDTO.setSampleUpdateDTOs(list);
        return sampleUpdateListDTO;
    }
}
