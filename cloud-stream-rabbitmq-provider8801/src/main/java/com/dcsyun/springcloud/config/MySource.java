package com.dcsyun.springcloud.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author zhengcj
 * @create 2020-11-19 11:50
 */
public interface MySource {
    String OUTPUT = "output";
    @Output(MySource.OUTPUT)
    MessageChannel output();
}
