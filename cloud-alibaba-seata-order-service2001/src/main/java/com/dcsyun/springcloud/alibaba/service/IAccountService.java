package com.dcsyun.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhengcj
 * @create 2020-12-08 15:57
 */
@FeignClient("seata-account-service")
public interface IAccountService {

    @PostMapping("reduce/account")
    public void reduceAccount(@RequestParam(value = "userId") Long userId, @RequestParam(value = "money") BigDecimal money);

}
