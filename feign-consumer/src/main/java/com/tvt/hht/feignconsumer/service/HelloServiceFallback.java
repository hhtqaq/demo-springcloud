package com.tvt.hht.feignconsumer.service;

import org.springframework.stereotype.Component;

/**
 * @author hht
 * @date 2019/7/17 17:20
 * @description
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello(String name) {
        return "error " + name;
    }
}
