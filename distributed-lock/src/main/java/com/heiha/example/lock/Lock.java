package com.heiha.example.lock;

import java.util.concurrent.TimeUnit;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:47<br>
 * <b>Author:</b> heiha<br>
 */
public interface Lock {
    /**
     * Acquires the lock without blocking, successful return true.
     * @return true/false
     * @throws LockException
     */
    boolean tryLock() throws LockException;

    /**
     * Releases the lock.
     * @throws LockException
     */
    void unlock() throws LockException;

    /**
     * Check lock status, locked return true.
     * @return true/false
     * @throws LockException
     */
    boolean isLocked() throws LockException;

    /**
     * Get value carried by the lock.
     * @return
     * @throws LockException
     */
    Object getLockValue() throws LockException;
}
