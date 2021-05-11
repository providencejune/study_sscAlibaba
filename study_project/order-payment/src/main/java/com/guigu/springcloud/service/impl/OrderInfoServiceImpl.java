package com.guigu.springcloud.service.impl;

import com.guigu.springcloud.dao.OrderInfoDao;
import com.guigu.springcloud.entity.OrderInfoEntity;
import com.guigu.springcloud.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoDao orderInfoDao;

    public int create(OrderInfoEntity entity) {
        return orderInfoDao.create(entity);
    }

    public OrderInfoEntity getById(Long id) {
        return orderInfoDao.getById(id);
    }
}
