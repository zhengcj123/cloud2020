package com.dcsyun.springcloud.alibaba.service;

import com.dcsyun.springcloud.alibaba.domain.Order;

/**
 * @author zhengcj
 * @create 2020-12-08 15:51
 */
public interface IOrderService {
    public void createOrder(Order order);
}
