package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.lb.LoadBalance;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author zhengcj
 * @create 2020-10-29 13:34
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalance loadBalance;

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/get/{id}")
    public CommonResult<Payment> selectSerialById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }
    @GetMapping("/getEntity/{id}")
    public CommonResult<Payment> selectSerialById2(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode().toString());
            return entity.getBody();
        }
        return new CommonResult<>(444,"获取失败");
    }

    @PostMapping("/create")
    @HystrixCommand
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @PostMapping("/createEntity")
    public CommonResult<Payment> addPayment2(@RequestBody Payment payment){
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return  entity.getBody();
        }
        return new CommonResult<>(444,"获取失败");
    }

    @GetMapping("/discover")
    public Object discoverInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/discover",Object.class);
    }

    @GetMapping("/lb")
    public String getServerPost(){
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service".toUpperCase());
        ServiceInstance instance = loadBalance.getInstance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    //下面是全局fallback方法
    public CommonResult<Payment> payment_Global_FallbackMethod(){
        return new CommonResult<>(444,"Global异常处理信息，请稍后再试,(┬＿┬)");
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }
}
