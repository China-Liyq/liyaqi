package com.chinaliyq.spring.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Author: liyq
 * @Description: demo
 * @Date: 2021/4/6 - 13:51
 * @Version: 1.0
 **/
@Configuration
public class MyRedisTemplate {
    @Bean
    public StringRedisTemplate ooxx(RedisConnectionFactory fc){
        System.out.println("666");
        StringRedisTemplate sr = new StringRedisTemplate(fc);
        sr.setHashKeySerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        sr.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return sr;

    }

//    @Bean
//    @SuppressWarnings("all")
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory fc){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(fc);
//        Jackson2JsonRedisSerializer<Object> jrs = new Jackson2JsonRedisSerializer<>(Object.class);
//        redisTemplate.setHashKeySerializer(jrs);
//        redisTemplate.setHashValueSerializer(jrs);
//        return redisTemplate;
//    }

}
