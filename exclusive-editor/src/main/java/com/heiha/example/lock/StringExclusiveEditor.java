package com.heiha.example.lock;

import com.heiha.example.lock.exception.LockException;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 12:02<br>
 * <b>Author:</b> heiha<br>
 */
public abstract class StringExclusiveEditor implements ExclusiveEditor<String, String> {
    protected StringLockSource lockSource;

    /** Lock source bean could be more than one, using @Autowired is unwise. */
    protected abstract void setLockSource();

    @Override
    public boolean tryLock(String lock, String holder) throws LockException {
        try {
            return lockSource.setIfAbsent(lock, holder);
        } catch (Exception e) {
            throw new LockException("Error when \"" + holder + "\" acquire the lock: " + lock);
        }
    }

    @Override
    public void unlock(String lock) throws LockException {
        try {
            lockSource.delete(lock);
        } catch (Exception e) {
            throw new LockException("Error when release the lock: " + lock);
        }
    }

    @Override
    public boolean isLocked(String lock) throws LockException {
        try {
            return lockSource.hasKey(lock);
        } catch (Exception e) {
            throw new LockException("Error when check the lock: " + lock);
        }
    }

    @Override
    public String getLockHolder(String lock) throws LockException {
        try {
            return lockSource.get(lock);
        } catch (Exception e) {
            throw new LockException("Error when get the lock holder, lock: " + lock);
        }
    }
}
