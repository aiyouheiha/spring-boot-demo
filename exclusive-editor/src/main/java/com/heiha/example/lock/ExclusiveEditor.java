package com.heiha.example.lock;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:47<br>
 * <b>Author:</b> heiha<br>
 *
 * <b>Exclusive editor</b><br>
 * Such a type of lock, which is distributed, having multi keys (multi sub-locks), <br>
 * and sub-lock will be acquired by value exclusive.
 */
public interface ExclusiveEditor<K, V> {
    /**
     * Acquires the lock without blocking, successful return true.
     * @param key
     * @param value
     * @return true/false
     * @throws LockException
     */
    boolean tryLock(K key, V value) throws LockException;

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
