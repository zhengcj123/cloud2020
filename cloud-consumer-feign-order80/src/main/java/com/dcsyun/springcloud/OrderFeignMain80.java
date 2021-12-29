package com.dcsyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhengcj
 * @create 2020-11-03 21:49
 */
@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
public class OrderFeignMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
