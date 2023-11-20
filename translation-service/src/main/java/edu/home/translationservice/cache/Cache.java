package edu.home.translationservice.cache;

public interface Cache<K, V> {

    V get(K key);
    void save(K key, V value);
}
