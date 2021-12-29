package com.dcsyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengcj
 * @create 2020-11-02 10:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkPaymentMain8004 {
    public static void main(String[] args){
        SpringApplication.run(ZkPaymentMain8004.class,args);
    }
}
