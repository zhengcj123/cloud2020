package com.dcsyun.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhengcj
 * @create 2020-11-05 9:33
 */
@Component
public class PaymentHystrixFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService--fallback--paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService--fallback--paymentInfo_TimeOut , (┬＿┬)";
    }

    @Override
    public String paymentInfo_RunException(Integer id) {
        return "-----PaymentFallbackService--fallback--paymentInfo_RunException , (┬＿┬)";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "-----PaymentFallbackService--fallback--paymentCircuitBreaker , (┬＿┬)";
    }
}
