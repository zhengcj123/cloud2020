package com.dcsyun.springcloud.service;

import com.dcsyun.springcloud.entities.Payment;

/**
 * @author zhengcj
 * @create 2020-10-29 9:40
 */
public interface IPaymentService {
    public Payment selectSerialById(Long id);
    public int addPaymnet(Payment payment);
}
