package com.dcsyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengcj
 * @create 2020-11-02 11:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(ZkOrderMain80.class,args);
    }
}
