package com.dcsyun.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhengcj
 * @create 2020-10-30 10:48
 */
@SpringBootApplication
@EnableEurekaClient
public class PrividerPamentMain8002 {
    public static void main(String[] args){
        SpringApplication.run(PrividerPamentMain8002.class,args);
    }
}
