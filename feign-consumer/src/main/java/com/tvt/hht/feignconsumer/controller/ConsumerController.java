package com.tvt.hht.feignconsumer.controller;

import com.tvt.hht.feignconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hht
 * @date 2019/7/17 15:21
 * @description
 */
@RestController
public class ConsumerController {
    @Resource
    private HelloService helloService;
    @GetMapping("/feign-consumer/{name}")
    public String helloConsumer(@PathVariable("name") String name) {
        return helloService.hello(name);
    }
}
