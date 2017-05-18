package com.heiha.example.lock;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 11:47<br>
 * <b>Author:</b> heiha<br>
 *
 * <b>Exclusive editor</b><br>
 * Exclusive editor is actually a type of lock set. It is distributed, having multi locks, <br>
 * and lock will be acquired by giving holder exclusive. <br>
 * <br>
 * Lock is NON re-entrant, once lock, following acquires failed until lock release.
 */
public interface ExclusiveEditor<L, H> {
    /**
     * Acquires the lock without blocking, successful return true. <br>
     * Lock is NON re-entrant.
     *
     * @param lock
     * @param holder
     * @return true/false
     * @throws LockException
     */
    boolean tryLock(L lock, H holder) throws LockException;

    /**
     * Releases the lock.
     * @param lock
     * @throws LockException
     */
    void unlock(L lock) throws LockException;

    /**
     * Check lock status, locked return true.
     * @return true/false
     * @throws LockException
     */
    boolean isLocked(L lock) throws LockException;

    /**
     * Get the lock holder.
     * @param lock
     * @return Lock holder
     * @throws LockException
     */
    H getLockHolder(L lock) throws LockException;
}
