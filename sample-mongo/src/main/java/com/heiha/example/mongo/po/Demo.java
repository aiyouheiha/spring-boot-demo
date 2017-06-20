package com.heiha.example.mongo.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;

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
@Entity
public class Demo {
    private Integer id;
    private String note;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public static class BaGua {
        private final String name = "八卦";
        private String note;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @Entity
        public static class Qian {
            private final String name = "乾";
            private String note;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @Entity
        public static class Kun {
            private final String name = "坤";
            private String note;
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public static class WuXing {
        private final String name = "五行";
        private WuXingType wuXingType;
        private String note;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public static class TaiJi {
        private final String name = "太极";
        private String note;
    }

}
