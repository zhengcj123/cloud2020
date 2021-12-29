package com.dcsyun.springcloud.service.impl;

//import com.dcsyun.springcloud.dao.PaymentDao;
import com.dcsyun.springcloud.dao.PaymentDao;
import com.dcsyun.springcloud.entities.Payment;
import com.dcsyun.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-10-29 9:41
 */
@Service
public class PaymentServiceImpl implements IPaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment selectSerialById(Long id) {
        return paymentDao.selectSerialById(id);
    }

    @Override
    public int addPaymnet(Payment payment) {
        return paymentDao.addPaymnet(payment);
    }
}
