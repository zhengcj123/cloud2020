package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import sun.management.Agent;

/**
 * @author zhengcj
 * @create 2020-12-08 15:26
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderServiceMain2001 {
    public static void main(String[] args){
        SpringApplication.run(SeataOrderServiceMain2001.class, args);
    }
}
