package com.dcsyun.springcloud;

import java.time.ZonedDateTime;

/**
 * @author zhengcj
 * @create 2020-11-09 17:46
 */
public class TestDemo {
    public static void main(String[] args){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }

}
