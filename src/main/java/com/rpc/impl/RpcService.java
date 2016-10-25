package com.rpc.impl;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Oliver.Liu on 3/30/2016.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component // 表明可被Spring 扫描
public @interface RpcService {
    Class<?> value();
}
