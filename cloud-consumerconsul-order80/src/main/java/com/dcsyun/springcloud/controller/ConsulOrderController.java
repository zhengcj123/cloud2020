package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-02 11:33
 */
@RestController
@Slf4j
public class ConsulOrderController {
    @Resource
    private RestTemplate restTemplate;

    private static final String SERVER_URL = "http://consul-provider-payment";

    @GetMapping("order/consul")
    public String paymentconsul(){
        String result = restTemplate.getForObject(SERVER_URL + "/payment/consul", String.class);
        System.out.println(result);
        return result;
    }


}
