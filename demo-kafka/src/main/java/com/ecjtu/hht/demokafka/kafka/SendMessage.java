package com.ecjtu.hht.demokafka.kafka;

import com.ecjtu.hht.demokafka.entity.Message;
import com.ecjtu.hht.demokafka.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息的发送方
 *
 * @author hht
 * @date 2019/8/24 16:21
 */
@Component
@Slf4j
public class SendMessage {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
        Message message = new Message();
        message.setDate(new Date());
        message.setMsg("hello kafka");
        message.setId(1L);
        log.info(JacksonUtils.jsonObjectSerializer(message));
        kafkaTemplate.send("hht",JacksonUtils.jsonObjectSerializer(message));
    }

}
