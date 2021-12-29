package com.dcsyun.springcloud.alibaba.service;

/**
 * @author zhengcj
 * @create 2020-12-09 16:33
 */
public interface IStorageService {
    public int reduce(Long productId, Integer count);
}
