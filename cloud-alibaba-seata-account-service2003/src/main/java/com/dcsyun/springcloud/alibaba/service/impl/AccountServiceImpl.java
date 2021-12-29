package com.dcsyun.springcloud.alibaba.service.impl;

import com.dcsyun.springcloud.alibaba.dao.AccountDao;
import com.dcsyun.springcloud.alibaba.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengcj
 * @create 2020-12-09 17:00
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountDao accountDao;
    @Override
    public int reduce(Long userId, BigDecimal money) {
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return accountDao.reduce(userId,money);
    }
}
