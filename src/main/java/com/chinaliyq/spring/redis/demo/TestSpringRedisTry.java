package com.chinaliyq.spring.redis.demo;

import com.chinaliyq.spring.redis.bean.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: liyq
 * @Description: demo
 * @Date: 2021/4/6 - 12:22
 * @Version: 1.0
 **/
@Component
public class TestSpringRedisTry {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
            @Qualifier("ooxx")
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public void testRedis(){
        HashOperations redisHash = redisTemplate.opsForHash();
        HashOperations<String, Object, Object> sRedisHash = stringRedisTemplate.opsForHash();
//        sRedisHash.put("role1","name","xy");
//        sRedisHash.put("role1","age","55");
//        System.out.println(sRedisHash.entries("role1"));
        Person person =new Person();
        person.setName("xiaoming");
        person.setAge(333);

        Jackson2HashMapper jackson2HashMapper = new Jackson2HashMapper(objectMapper, false);

//        redisHash.putAll("xm",jackson2HashMapper.toHash(person));
//        Map xm = redisHash.entries("xm");
//        Person person1 = objectMapper.convertValue(xm, Person.class);
//        System.out.println(person1);
//        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
//        stringRedisTemplate.setHashKeySerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        sRedisHash.putAll("xiao",jackson2HashMapper.toHash(person));
        Map xm = sRedisHash.entries("xiao");
        Person person1 = objectMapper.convertValue(xm, Person.class);
        System.out.println(person1);


//        RedisConnection con = redisTemplate.getConnectionFactory().getConnection();
//        con.set("hello1".getBytes(),"china1".getBytes());
//        byte[] bytes = con.get("hello1".getBytes());
//        System.out.println("字节："+bytes+"\n字符："+new String(bytes));


//        redisTemplate.opsForValue().set("hello","china");
//        System.out.println(redisTemplate.opsForValue().get("hello"));
//
//        stringRedisTemplate.opsForValue().set("66", String.valueOf(55));
//        System.out.println(stringRedisTemplate.opsForValue().get("66"));

    }





}
