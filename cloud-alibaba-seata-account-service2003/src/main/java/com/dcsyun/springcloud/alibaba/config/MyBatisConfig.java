package com.dcsyun.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.dcsyun.springcloud.alibaba.dao"})
public class MyBatisConfig {
 
}