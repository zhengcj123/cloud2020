package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengcj
 * @create 2020-11-24 16:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9002 {
    public static void main(String[] args){
        SpringApplication.run(ProviderPaymentMain9002.class,args);
    }
}
