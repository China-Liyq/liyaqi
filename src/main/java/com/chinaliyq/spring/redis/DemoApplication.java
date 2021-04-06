package com.chinaliyq.spring.redis;

import com.chinaliyq.spring.redis.demo.TestSpringRedisTry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        TestSpringRedisTry redis = ctx.getBean(TestSpringRedisTry.class);
        redis.testRedis();
    }

}
