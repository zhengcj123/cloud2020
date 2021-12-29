package com.dcsyun.springcloud.alibaba.dao;

import com.dcsyun.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengcj
 * @create 2020-12-08 15:34
 */
@Mapper
public interface OrderDao {
    public int addOrder(Order order);

    public int updateOrderStatus(@Param(value = "userId") Long userId,@Param(value = "status") Integer status);
}
