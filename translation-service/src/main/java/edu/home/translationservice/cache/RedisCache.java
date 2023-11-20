package edu.home.translationservice.cache;

import edu.home.translationservice.proxy.translator.Translator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCache implements Cache<String, String> {

    private final RedisTemplate<String, String> redis;

    public RedisCache(RedisTemplate<String, String> redis) {
        this.redis = redis;
    }

    @Override
    public String get(String key) {
        return redis.boundValueOps(key).get();
    }

    @Override
    public void save(String key, String value) {
        redis.boundValueOps(key).set(value);
    }
}
