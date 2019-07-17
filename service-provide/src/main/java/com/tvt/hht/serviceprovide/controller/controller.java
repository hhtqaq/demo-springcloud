package com.tvt.hht.serviceprovide.controller;

import com.tvt.hht.serviceprovide.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hht
 * @date 2019/7/17 10:04
 * @description
 */
@RestController
public class controller {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello-provider/{name}")
    public String hello(@PathVariable("name") String name) {
        System.out.println("I  am   provider");
        return helloService.hello(name);
    }

}
