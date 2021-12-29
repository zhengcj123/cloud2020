package com.dcsyun.springcloud.service;

import com.dcsyun.springcloud.entities.Payment;

/**
 * @author zhengcj
 * @create 2020-11-11 11:31
 */
public interface IMessageProvider {
    public Payment send();
}
