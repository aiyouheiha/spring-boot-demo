package com.heiha.example.lock.locks;

import com.heiha.example.lock.StringExclusiveEditor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 14:28<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "lock", name = "type", havingValue = "redis")
@Component
public class RedisBasedExclusiveEditor extends StringExclusiveEditor {
    @Override
    protected void setLockSource() {

    }
}
