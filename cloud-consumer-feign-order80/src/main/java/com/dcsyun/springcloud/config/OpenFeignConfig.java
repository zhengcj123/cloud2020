package com.dcsyun.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhengcj
 * @create 2020-11-04 10:37
 */
@Component
public class OpenFeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
