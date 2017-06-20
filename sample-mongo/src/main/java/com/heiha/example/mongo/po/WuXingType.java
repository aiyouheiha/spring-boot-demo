package com.heiha.example.mongo.po;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/20 17:39<br>
 * <b>Author:</b> heiha<br>
 */
public enum WuXingType {
    JIN("金", 1),
    MU("木", 2),
    SHUI("水", 3),
    HUO("火", 4),
    TU("土", 5);

    private String name;
    private Integer code;

    WuXingType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }
}
