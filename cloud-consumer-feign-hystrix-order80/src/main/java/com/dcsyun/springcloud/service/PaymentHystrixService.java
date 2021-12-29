package com.dcsyun.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhengcj
 * @create 2020-11-04 15:14
 */
@Component
@FeignClient(value = "CLOUD-PAYMENTHYSTRIX-SERVICE",fallback = PaymentHystrixFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/runException/{id}")
    public String paymentInfo_RunException(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
