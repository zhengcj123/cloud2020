package com.dcsyun.springcloud.service;

import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhengcj
 * @create 2020-11-03 21:56
 */
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectSerialById(@PathVariable(value="id") Long id);

    @GetMapping("/payment/timeOut")
    public String paymentFeignTimeOut();
}
