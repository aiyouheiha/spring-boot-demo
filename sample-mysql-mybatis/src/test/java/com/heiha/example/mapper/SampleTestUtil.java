package com.heiha.example.mapper;

import com.heiha.example.dto.SampleInsertDTO;

import java.util.Random;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 18:06<br>
 * <b>Author:</b> heiha<br>
 */
public class SampleTestUtil {
    private static Random random = new Random(3);

    public static SampleInsertDTO newSampleInsertDTO() {
        SampleInsertDTO sampleInsertDTO = new SampleInsertDTO();
        sampleInsertDTO.setCreateUserId("");
        sampleInsertDTO.setVersion(String.valueOf(random.nextInt()));
        return sampleInsertDTO;
    }

    public static enum User {
        USER1, USER2, USER3;


    }

}
