package com.example.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-29 下午6:20
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitMqReceiver {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println(msg);
    }
}
