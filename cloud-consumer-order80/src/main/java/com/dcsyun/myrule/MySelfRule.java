package com.dcsyun.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengcj
 * @create 2020-11-03 14:49
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getMyRule(){
        return new RandomRule();
    }
}
