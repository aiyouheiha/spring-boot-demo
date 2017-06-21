package com.heiha.example.mongo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 17:17<br>
 * <b>Author:</b> heiha<br>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
    private String id;
    private String name;
    private WuXingType wuXingType;
    private String note;
}
