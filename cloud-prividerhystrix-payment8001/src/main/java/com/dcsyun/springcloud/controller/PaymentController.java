package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }
    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        return result;
    }
    @GetMapping("/hystrix/runException/{id}")
    public String paymentInfo_RunException(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_RunException(id);
        return result;
    }

    // ======熔断======
    @GetMapping("/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
 
 
