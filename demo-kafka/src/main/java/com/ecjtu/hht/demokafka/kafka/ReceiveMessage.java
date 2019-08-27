package com.ecjtu.hht.demokafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息的接收方
 *
 * @author hht
 * @date 2019/8/24 16:22
 */
@Component
@Slf4j
public class ReceiveMessage {
    @KafkaListener(topics = {"hht"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object o = message.get();
            log.info("record=" + record);
            log.info("message=" + message);
        }
    }
}
