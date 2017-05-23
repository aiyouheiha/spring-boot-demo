package com.heiha.example.mongo.po;

import com.heiha.example.po.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/23 11:21<br>
 * <b>Author:</b> heiha<br>
 */
@Document(collection = "sample")
public class MongoSamplePO extends BaseEntity {
    @Id
    private String id;
    private String note;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
