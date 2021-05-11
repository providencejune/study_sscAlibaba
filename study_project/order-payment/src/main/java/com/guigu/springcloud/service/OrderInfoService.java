package com.guigu.springcloud.service;


import com.guigu.springcloud.entity.OrderInfoEntity;

public interface OrderInfoService {
    /**
     * @param entity
     * @return
     */
    public int create(OrderInfoEntity entity);

    /**
     * @param id
     * @return
     */
    public OrderInfoEntity getById(Long id);
}
