package com.dcsyun.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zhengcj
 * @create 2020-12-09 16:59
 */
public interface IAccountService {
    public int reduce(Long userId, BigDecimal money);
}
