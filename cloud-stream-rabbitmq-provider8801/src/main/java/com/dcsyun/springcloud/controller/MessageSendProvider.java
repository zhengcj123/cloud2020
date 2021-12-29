package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-11-11 11:52
 */
@RestController
public class MessageSendProvider {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/messageSend")
    public Payment messageSend(){
        return messageProvider.send();
    }
}
