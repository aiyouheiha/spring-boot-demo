package com.heiha.example.dto;

import java.util.List;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/12 11:00<br>
 * <b>Author:</b> heiha<br>
 */
public class SampleUpdateListDTO {
    private String updateUserId;
    private List<SampleUpdateDTO> sampleUpdateDTOs;

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public List<SampleUpdateDTO> getSampleUpdateDTOs() {
        return sampleUpdateDTOs;
    }

    public void setSampleUpdateDTOs(List<SampleUpdateDTO> sampleUpdateDTOs) {
        this.sampleUpdateDTOs = sampleUpdateDTOs;
    }
}
