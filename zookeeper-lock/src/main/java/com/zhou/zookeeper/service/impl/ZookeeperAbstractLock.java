package com.zhou.zookeeper.service.impl;

import com.zhou.zookeeper.service.Lock;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public abstract class ZookeeperAbstractLock implements Lock {

    protected String url = "192.168.91.139:2181,192.168.91.140:2181,192.168.91.141:2181";

    protected ZkClient zkClient = new ZkClient(url);


    protected String PATH = "/zk---lock";

    public void getLock() {
        // 如果当前节点已经存在,则等待
        if (tryLock()) {
            System.out.println("获取到锁 get");
        } else {
            // 等待
            waitLock();
            // 重新获取锁
            getLock();
        }
    }

    protected abstract void waitLock();

    protected abstract boolean tryLock();

    public void unLock() {
        if (zkClient != null) {
            zkClient.close();
        }
        System.out.println("已经释放锁...");
    }
}