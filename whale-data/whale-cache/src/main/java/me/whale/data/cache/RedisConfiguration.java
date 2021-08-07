package me.whale.data.cache;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

@Configuration
@Profile("cache")
public class RedisConfiguration {
    @Qualifier("redissonConnectionFactory")
    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public <K, V> RedisTemplate<K, V> redisTemplate(RedisConnectionFactory redissonConnectionFactory) {
        final RedisTemplate<K, V> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redissonConnectionFactory);
        return template;
    }

}
