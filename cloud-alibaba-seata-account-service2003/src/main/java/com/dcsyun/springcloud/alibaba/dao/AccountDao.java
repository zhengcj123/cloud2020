package com.dcsyun.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zhengcj
 * @create 2020-12-09 16:54
 */
@Mapper
public interface AccountDao {
    public int reduce(@Param(value = "userId") Long userId,@Param(value = "money") BigDecimal money);
}
