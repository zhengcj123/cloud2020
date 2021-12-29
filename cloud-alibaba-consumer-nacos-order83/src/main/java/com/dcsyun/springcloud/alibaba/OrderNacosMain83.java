package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhengcj
 * @create 2020-11-24 17:02
 */

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name="nacos-payment-provider")
public class OrderNacosMain83 {
    public static void main(String[] args){
        SpringApplication.run(OrderNacosMain83.class,args);
    }
}
