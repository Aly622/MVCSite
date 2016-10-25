package com.rpc.impl;

import com.rpc.HelloService;

/**
 * Created by Oliver.Liu on 3/30/2016.
 */
@RpcService(HelloService.class) // 指定远程接口
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }
}
