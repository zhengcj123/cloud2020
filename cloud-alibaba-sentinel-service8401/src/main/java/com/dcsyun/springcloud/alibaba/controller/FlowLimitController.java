package com.dcsyun.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dcsyun.springcloud.entities.Payment;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhengcj
 * @create 2020-11-30 15:15
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        // 慢调用比列  比列阈值[0.0,1.0]：每秒异常总数占通过量的比值
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        int num = 10/0;
        return "------testA";
    }
    @GetMapping("/testC")
    public String testC() {

        return "------testC";
    }

    @GetMapping("/testB")
    public String testB() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value="testHotKey",blockHandler = "deal_hotKey")
    public String testHotKey(Payment p1, String p2){
        int num = 10/0;
        return "testHotKey：p1="+p1+";p2="+p2;
    }

    public String deal_hotKey(Payment p1,String p2,BlockException exception){
        return "testHotKey o(╥﹏╥)o";
    }


}
