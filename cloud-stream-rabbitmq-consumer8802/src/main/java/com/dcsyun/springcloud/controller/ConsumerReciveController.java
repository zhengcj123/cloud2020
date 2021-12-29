package com.dcsyun.springcloud.controller;

import com.dcsyun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author zhengcj
 * @create 2020-11-12 20:48
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ConsumerReciveController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void  receive(Message<Payment> message){
        Payment payload = message.getPayload();
        log.info("消费者1号，接受："+payload+"\t port:"+serverPort);
    }
}
