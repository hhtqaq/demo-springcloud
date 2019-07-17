package com.tvt.hht.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @author hht
 * @date 2019/7/17 15:15
 * @description 申明式服务调用
 * <p>
 * 服务降级 通过实现服务接口  在feignClient中指定fallback类名
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {
    @GetMapping("/hello-provider/{name}")
    String hello(@PathVariable("name") String name);
}
