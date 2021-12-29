package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengcj
 * @create 2020-10-29 9:54
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectSerialById(@PathVariable Long id){
        Payment payment = paymentService.selectSerialById(id);
        log.info(payment.toString());
        if (payment != null) {
            return new CommonResult<>(200, "获取成功:"+port, payment);
        }
        return new CommonResult<>(300,"获取失败:"+port);
    }

    @PostMapping("/create")
    @Transactional
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        int num = paymentService.addPaymnet(payment);
        int age = 10/0;
        if (num != 0) {
            return new CommonResult<>(200,"创建成功:"+port,payment);
        }
        return new CommonResult<>(300,"创建失败:"+port);
    }

    @GetMapping("/discover")
    public Object discoverInfo(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service.toUpperCase());
            for (ServiceInstance instance : instances) {
                log.info(port+"\t"+instance.getServiceId()+"\t"+instance.getUri().toString());
            }
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getServerPost(){
        return port;
    }

    // OpenFeign默认等待时间1秒，超时报错
    @GetMapping("/timeOut")
    public String paymentFeignTimeOut(){
        log.info("****timeOut*****port:"+port);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout:"+port;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}
