package com.rpc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Oliver.Liu on 3/31/2016.
 */
public class RpcBootstrap {
    public static void main(String[] args)
    {
        new ClassPathXmlApplicationContext("spring-mvc.xml");
    }
}
