package com.dcsyun.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.dcsyun.springcloud.config.MySource;
import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;


/**
 * @author zhengcj
 * @create 2020-11-11 11:31
 */
@EnableBinding(MySource.class)
//@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public Payment send() {
        Payment payment = new Payment();
        String uuid = IdUtil.simpleUUID();
        payment.setId(100L);
        payment.setSerial(uuid);
        log.info("********"+uuid);
        boolean send = output.send(MessageBuilder.withPayload(payment).build());
        if(send){
            return payment;
        }
        return null;
    }
}
