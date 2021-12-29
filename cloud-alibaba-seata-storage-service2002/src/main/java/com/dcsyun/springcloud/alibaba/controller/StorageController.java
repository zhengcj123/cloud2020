package com.dcsyun.springcloud.alibaba.controller;

import com.dcsyun.springcloud.alibaba.service.IStorageService;
import com.dcsyun.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-12-09 16:36
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PostMapping("reduce/storage")
    public CommonResult reduce(@RequestParam(value = "productId") Long productId,@RequestParam(value = "count") Integer count) {
        storageService.reduce(productId,count);
        return new CommonResult(200,"减少库存成功");
    }
}
