package me.whale.data.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisOps<K, V> {
    @Resource
    private RedisTemplate<K, V> redisTemplate;

    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(K key, V value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }


}
