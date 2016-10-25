package com.rpc;

/**
 * Created by Oliver.Liu on 3/30/2016.
 */
public interface Constant {
    int ZK_SESSION_TIMEOUT = 5000;

    String ZK_REGISTRY_PATH = "/registry"; //需要使用 ZooKeeper 客户端命令行创建/registry永久节点，用于存放所有的服务临时节点
    String ZK_DATA_PATH = ZK_REGISTRY_PATH  + "/data";
}
