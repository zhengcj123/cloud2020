package com.dcsyun.springcloud.alibaba.controller;

import com.dcsyun.springcloud.alibaba.domain.Order;
import com.dcsyun.springcloud.alibaba.service.IOrderService;
import com.dcsyun.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-12-08 20:46
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private IOrderService orderService;

    @GetMapping("reduce/order")
    public CommonResult createOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"下订单成功");
    }
}
