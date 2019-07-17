package com.tvt.hht.serviceconsumer.service;

/**
 * @author hht
 * @date 2019/7/17 13:54
 * @description
 */
public interface HelloService {
    String hello(String name);
    String helloFallback(String name,Throwable throwable);
}
