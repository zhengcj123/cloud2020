package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-03 21:55
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService feignService;
    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> selectSerialById(@PathVariable(value="id") Long id){
        return feignService.selectSerialById(id);
    }
    @GetMapping("/consumer/timeOut")
    public String paymentFeignTimeOut(){
        return feignService.paymentFeignTimeOut();
    }
}
