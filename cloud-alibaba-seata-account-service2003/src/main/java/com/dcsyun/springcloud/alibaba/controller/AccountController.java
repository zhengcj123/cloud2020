package com.dcsyun.springcloud.alibaba.controller;

import com.dcsyun.springcloud.alibaba.service.IAccountService;
import com.dcsyun.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author zhengcj
 * @create 2020-12-09 17:03
 */
@RestController
@Slf4j
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PostMapping("reduce/account")
    public CommonResult reduce(@RequestParam(value = "userId") Long userId, @RequestParam(value = "money") BigDecimal money) {
        accountService.reduce(userId,money);
        return new CommonResult(200,"减少余额成功");
    }
}
