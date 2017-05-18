package com.heiha.example.lock;

import com.heiha.example.lock.exception.LockException;
import com.heiha.example.lock.locks.MemcachedBasedLock;
import com.heiha.example.lock.locks.RedisBasedLock;
import com.heiha.example.lock.locks.ZooKeeperBasedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 16:20<br>
 * <b>Author:</b> heiha<br>
 *
 * Load only when lock.type has been set.
 */
@ConditionalOnProperty(prefix = "lock", name = "type")
@Component
public class LockHelper implements ExclusiveEditor<String, String> {
    /**
     * Limit by ConditionalOnProperty, Only lock.type set in application.properties will be loaded. <br>
     *
     * @see MemcachedBasedLock
     * @see RedisBasedLock
     * @see ZooKeeperBasedLock
     */
    @Autowired
    private StringExclusiveEditor exclusiveEditor;

    @Override
    public boolean tryLock(String lock, String holder) throws LockException {
        return exclusiveEditor.tryLock(lock, holder);
    }

    @Override
    public void unlock(String lock) throws LockException {
        exclusiveEditor.unlock(lock);
    }

    @Override
    public boolean isLocked(String lock) throws LockException {
        return exclusiveEditor.isLocked(lock);
    }

    @Override
    public String getLockHolder(String lock) throws LockException {
        return exclusiveEditor.getLockHolder(lock);
    }
}
