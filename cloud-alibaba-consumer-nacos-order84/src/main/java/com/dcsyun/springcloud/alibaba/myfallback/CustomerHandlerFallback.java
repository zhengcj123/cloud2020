package com.dcsyun.springcloud.alibaba.myfallback;

import com.dcsyun.springcloud.entities.CommonResult;
import com.dcsyun.springcloud.entities.Payment;

/**
 * @author zhengcj
 * @create 2020-12-03 16:14
 */
public class CustomerHandlerFallback {

    public static CommonResult<Payment> handlerFallback(Long id, Throwable exception) {
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"客户自定义异常信息:"+exception.getMessage(),payment);
    }
}
