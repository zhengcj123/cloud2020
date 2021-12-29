package com.dcsyun.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengcj
 * @create 2020-12-09 16:24
 */
@Mapper
public interface StorageDao {
    public int reduce(@Param(value = "productId") Long productId, @Param(value = "count") Integer count);
}
