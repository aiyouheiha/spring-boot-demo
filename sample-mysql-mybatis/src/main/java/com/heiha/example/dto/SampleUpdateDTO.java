package com.heiha.example.dto;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 16:07<br>
 * <b>Author:</b> heiha<br>
 */
public class SampleUpdateDTO {
    /** Sample id which needs to update */
    private long id;

    /** new version */
    private String version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
