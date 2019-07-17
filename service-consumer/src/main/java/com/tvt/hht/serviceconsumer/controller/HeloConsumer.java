package com.tvt.hht.serviceconsumer.controller;

import com.tvt.hht.serviceconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hht
 * @date 2019/7/17 10:34
 * @description
 */
@RestController
public class HeloConsumer {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello-consumer/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name);
    }

}
