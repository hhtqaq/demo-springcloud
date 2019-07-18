package com.tvt.hht.serviceconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hht
 * @date 2019/7/17 13:55
 * @description
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String HELLO_SERVICE_PREFIX = "http://hello-service/";
    private static final String ERROR="error";
    /*指定失败回调函数*/
    @HystrixCommand(fallbackMethod = "helloFallback", ignoreExceptions = {HystrixBadRequestException.class})
    @Override
    public String hello(String name) {
        return restTemplate.getForObject(HELLO_SERVICE_PREFIX + "hello-provider/{0}", String.class, name);

    }

    @Override
    public String helloFallback(String name, Throwable throwable) {
        return ERROR + name;
    }
}
