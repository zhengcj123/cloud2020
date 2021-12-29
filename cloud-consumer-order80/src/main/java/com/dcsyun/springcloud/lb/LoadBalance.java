package com.dcsyun.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhengcj
 * @create 2020-11-03 20:33
 */
public interface LoadBalance {

    public ServiceInstance getInstance(List<ServiceInstance> list);
}
