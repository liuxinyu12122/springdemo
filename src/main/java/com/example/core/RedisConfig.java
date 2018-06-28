package com.example.core;

import com.example.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-26 下午6:52
 */
@Configuration
public class RedisConfig {
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory(){
////        return new JedisConnectionFactory();
//        return null;
//    }

    @Bean
//    @ConditionalOnMissingBean(name="redisTemplate")
    public RedisTemplate<String,User> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
//    @ConditionalOnMissingBean(name="redisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

//    @Bean
//    public RedisTemplate<String,User> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
//        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
//        template.setConnectionFactory(new JedisConnectionFactory());
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new RedisObjectSerializer());
//        return template;
//    }
}
