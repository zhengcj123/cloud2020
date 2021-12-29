package com.dcsyun.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dcsyun.springcloud.entities.CommonResult;

/**
 * @author zhengcj
 * @create 2020-12-03 14:23
 */
public class CustomerHandler {
    public static CommonResult handler1(BlockException exception){
        return new CommonResult(444,"CustomerHandler,handler1");
    }
    public static CommonResult handler2(BlockException exception){
        return new CommonResult(444,"CustomerHandler,handler2");
    }
}
