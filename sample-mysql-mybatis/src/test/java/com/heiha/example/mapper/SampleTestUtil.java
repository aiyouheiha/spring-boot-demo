package com.heiha.example.mapper;

import com.heiha.example.dto.SampleDeleteDTO;
import com.heiha.example.dto.SampleInsertDTO;

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
}
