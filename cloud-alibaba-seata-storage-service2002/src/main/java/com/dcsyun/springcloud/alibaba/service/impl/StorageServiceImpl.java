package com.dcsyun.springcloud.alibaba.service.impl;

import com.dcsyun.springcloud.alibaba.dao.StorageDao;
import com.dcsyun.springcloud.alibaba.service.IStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhengcj
 * @create 2020-12-09 16:34
 */
@Service
public class StorageServiceImpl implements IStorageService {

    @Resource
    private StorageDao storageDao;
    @Override
    public int reduce(Long productId, Integer count) {
        return storageDao.reduce(productId,count);
    }
}
