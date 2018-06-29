package com.example.core;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-29 下午6:27
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
