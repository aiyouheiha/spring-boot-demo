package com.heiha.example.lock;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 15:56<br>
 * <b>Author:</b> heiha<br>
 *
 * Lock source implementations should implement methods under this interface. <br>
 * Methods under this interface should ensure atomicity.
 *
 * @see com.heiha.example.lock.ExclusiveEditor
 */
public interface LockSource<K, V> {
    boolean setIfAbsent(K key, V value) throws Exception;
    void delete(K key) throws Exception;
    boolean hasKey(K key) throws Exception;
    V get(K key) throws Exception;
}
