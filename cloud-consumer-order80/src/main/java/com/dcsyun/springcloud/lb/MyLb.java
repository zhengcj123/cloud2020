package com.dcsyun.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhengcj
 * @create 2020-11-03 20:34
 */

@Component
@Slf4j
public class MyLb implements  LoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int incrementAndGetModulo(){
        int current,next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE?0:current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("*****当前点击次数为*****:"+next);
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> list) {
        if(list != null && !list.isEmpty()){
            int index = incrementAndGetModulo() % list.size();
            return list.get(index);
        }
        return null;
    }
}
