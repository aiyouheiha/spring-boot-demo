package com.heiha.example.lock.editors;

import com.heiha.example.lock.StringExclusiveEditor;
import com.heiha.example.memcached.MemcachedHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 14:29<br>
 * <b>Author:</b> heiha<br>
 */
@ConditionalOnProperty(prefix = "lock", name = "type", havingValue = "memcached")
@ConditionalOnBean(MemcachedHelper.class)
@Component
public class MemcachedBasedExclusiveEditor extends StringExclusiveEditor {
    @Autowired
    private MemcachedHelper memcachedHelper;

    @Override
    protected void setLockSource() {
    }
}
