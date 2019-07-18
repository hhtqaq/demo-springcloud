package com.tvt.hht.rabbitmqhello.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hht
 * @date 2019/7/18 19:55
 * @description 消息的接受者
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @RabbitHandler
    public void process(String hello) {
        logger.info("receiver___" + hello);
    }
}
