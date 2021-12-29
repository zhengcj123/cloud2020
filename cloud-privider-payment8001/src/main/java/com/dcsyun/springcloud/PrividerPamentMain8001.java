package com.dcsyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhengcj
 * @create 2020-10-28 21:19
 */

// @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到该服务。
// 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心(Zookeeper、Consul../)。
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class PrividerPamentMain8001 {
    public static void main(String[] args){
        SpringApplication.run(PrividerPamentMain8001.class,args);
    }
}
