package com.dcsyun.springcloud.dao;

import com.dcsyun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengcj
 * @create 2020-10-28 22:12
 */
@Mapper
public interface PaymentDao {
    public Payment selectSerialById(@Param(value="id") Long id);

    public int addPaymnet(Payment payment);
}
