package com.dcsyun.springcloud.alibaba.service.impl;

import com.dcsyun.springcloud.alibaba.dao.OrderDao;
import com.dcsyun.springcloud.alibaba.domain.Order;
import com.dcsyun.springcloud.alibaba.service.IAccountService;
import com.dcsyun.springcloud.alibaba.service.IOrderService;
import com.dcsyun.springcloud.alibaba.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创订单--》减库存--》减余额--》该状态
 * @author zhengcj
 * @create 2020-12-08 15:51
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private IStorageService storageService;
    @Resource
    private IAccountService accountService;
    @Override
    @GlobalTransactional(name = "aaaa",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("-----创建订单-----");
        int orderNum = orderDao.addOrder(order);
        log.info("-----减库存-----");
        storageService.reduceStorage(order.getProductId(),order.getCount());
        log.info("-----减余额-----");
        accountService.reduceAccount(order.getUserId(),order.getMoney());
        log.info("-----改状态-----");
        orderDao.updateOrderStatus(order.getUserId(),0);

        log.info("创建订单结束");
    }
}
