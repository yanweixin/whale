package me.whale.data.cache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@DataRedisTest
@ActiveProfiles("cache")
class RedisTest {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void test(){
        redisTemplate.opsForValue().set("a","b");
        redisTemplate.opsForValue().set("b","c");
        redisTemplate.opsForValue().set("c","d");
        String a = redisTemplate.opsForValue().get("c");
        System.out.println(a);
    }
}