package com.tvt.hht.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hht
 * @date 2019/7/18 15:05
 * @description 创建一个restful接口 来返回配置中心的from属性 通过@value绑定
 * 配置服务中的from属性
 */
@RefreshScope
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

    @RequestMapping("/from2")
    public String from2() {
        return environment.getProperty("from", "undefined");
    }
}
