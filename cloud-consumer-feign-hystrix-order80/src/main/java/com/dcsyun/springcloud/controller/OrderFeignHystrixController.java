package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-04 15:16
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
// 全局统一处理，对要降级的方法上只添加@HystrixCommand
// payment_Global_FallbackMethod中降级处理的方法高于PaymentHystrixFallBackService中的paymentInfo_TimeOut方法
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderFeignHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod="paymentInfo_TimeOutFallBack",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        log.info("****80 timeout****");
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String paymentInfo_TimeOutFallBack(@PathVariable("id") Integer id){
        return "线程池："+Thread.currentThread().getName()+"\t80服务暂忙\t"+id;
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }

    @GetMapping("/hystrix/runException/{id}")
    public String paymentInfo_RunException(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_RunException(id);
    }

    @GetMapping("/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentCircuitBreaker(id);
    }

}
