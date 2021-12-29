package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengcj
 * @create 2020-12-03 15:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9004 {
    public static void main(String[] args){
        SpringApplication.run(ProviderPaymentMain9004.class,args);
    }
}
