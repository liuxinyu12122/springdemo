package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 刘心宇
 * @Description
 * @Date 创建于 18-6-29 下午6:20
 */
@Component
public class RabbitMqSender {
    Logger logger = LoggerFactory.getLogger(RabbitMqSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void sender(){
        String context = "hello:" + new Date();
        logger.info("sender:{}",context);
        amqpTemplate.convertAndSend("hello",context);
    }
}
