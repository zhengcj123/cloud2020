package com.dcsyun.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhengcj
 * @create 2020-12-08 15:57
 */
@FeignClient("seata-storage-service")
public interface IStorageService {

    @PostMapping("reduce/storage")
    public void reduceStorage(@RequestParam(value = "productId") Long productId, @RequestParam(value = "count") Integer count);

}
