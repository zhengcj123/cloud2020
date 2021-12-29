package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengcj
 * @create 2020-11-30 15:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
    public static void main(String[] args){
        SpringApplication.run(SentinelServiceMain8401.class,args);
    }
}
