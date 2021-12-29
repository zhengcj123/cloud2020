package com.dcsyun.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dcsyun.springcloud.alibaba.myfallback.CustomerHandlerFallback;
import com.dcsyun.springcloud.alibaba.service.PaymentService;
import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-30 15:14
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${service-url.nacos-user-service}")
    public String SERVICE_URL;
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    // 什么都没有配置
//    @SentinelResource(value="fallback")

    // fallback只负责业务异常
//    @SentinelResource(value="fallback",fallback = "handlerFallback")

//    @SentinelResource(value="fallback",fallbackClass = {CustomerHandlerFallback.class},fallback = "handlerFallback")

    // blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value="fallback",blockHandler = "blockHandlerException")

    // blockHandler和fallback同时满足blockHandler优先
//    @SentinelResource(value="fallback",blockHandler = "blockHandlerException",fallback = "handlerFallback")

    @SentinelResource(value="fallback",blockHandler = "blockHandlerException",fallback = "handlerFallback",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id, CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    public  CommonResult<Payment> handlerFallback(Long id, Throwable exception) {
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"fallback异常信息:"+exception.getMessage(),payment);
    }

    public  CommonResult<Payment> blockHandlerException(Long id, BlockException exception) {
        Payment payment = new Payment(id,null);
        return new CommonResult(445,"sentinel异常信息:"+exception.getMessage(),payment);
    }

    // OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    // sentinel中的blockHandler降级 > feign降级 > sentinel中的fallback降级
    @SentinelResource(value="openFeignFallBack",blockHandler = "blockHandlerException",fallback = "handlerFallback")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}