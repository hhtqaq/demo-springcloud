package com.ecjtu.hht.demokafka.entity;

import lombok.Data;

import java.util.Date;

/**
 * 消息实体类
 *
 * @author hht
 * @date 2019/8/24 16:25
 */
@Data
public class Message {
    private Long id;
    private String msg;
    private Date date;
}
