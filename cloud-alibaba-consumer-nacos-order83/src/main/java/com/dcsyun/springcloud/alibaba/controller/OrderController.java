package com.dcsyun.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-24 17:04
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate template;

    @Value("${service-url.nacos-user-service}")
    private String server_url;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        String result = template.getForObject(server_url+"/payment/nacos/"+id, String.class);
        log.info(result);
        return result;
    }

}
