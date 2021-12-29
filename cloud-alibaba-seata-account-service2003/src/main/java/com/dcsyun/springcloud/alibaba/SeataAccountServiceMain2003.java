package com.dcsyun.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhengcj
 * @create 2020-12-09 16:22
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
@EnableFeignClients
@EnableDiscoveryClient
public class SeataAccountServiceMain2003 {
    public static void main(String[] args){
        SpringApplication.run(SeataAccountServiceMain2003.class,args);
    }
}
