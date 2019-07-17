package com.tvt.hht.serviceprovide.service;

import org.springframework.stereotype.Service;

/**
 * @author hht
 * @date 2019/7/17 10:04
 * @description
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
