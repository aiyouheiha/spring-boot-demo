package com.heiha.example.dto;

import java.util.Date;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/11 15:19<br>
 * <b>Author:</b> heiha<br>
 */
public class SampleInsertDTO {
    /** Save generated id */
    private long id;

    /** Create User Id */
    private String createUserId;

    /** Initial Version */
    private String version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
