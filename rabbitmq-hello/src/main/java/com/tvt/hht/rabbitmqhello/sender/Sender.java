package com.tvt.hht.rabbitmqhello.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hht
 * @date 2019/7/18 19:52
 * @description 消息的生产者
 */
@Component
public class Sender {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String msg) {
        logger.info("Sender__:" + msg);
        this.rabbitTemplate.convertAndSend("hello", msg);
    }
}
