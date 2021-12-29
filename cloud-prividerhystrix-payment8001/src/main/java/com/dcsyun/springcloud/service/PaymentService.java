package com.dcsyun.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    //成功
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈"  ;
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int num = 5/0;
        log.info(Thread.currentThread().getName()+"*****8001 sleep start*****");
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        log.info(Thread.currentThread().getName()+"*****8001 sleep end*****");
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_RunException(Integer id){
        int num = 5/0;
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_RunException,id：  "+id+"\t"+"呜呜呜";
    }

    public String paymentInfo_TimeOutFallBack(Integer id){
        log.info("线程池："+Thread.currentThread().getName()+"\t8001服务暂忙\t"+id);
        return "线程池："+Thread.currentThread().getName()+"\t8001服务暂忙\t"+id;
    }


    // ======熔断=======
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000")  //时间范围
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

}
 
 
