package com.guigu.springcloud.dao;

import com.guigu.springcloud.entity.OrderInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mybatis 会有一个拦截器，会自动的把 @Mapper 注解的接口生成动态代理类。这点可以在 MapperRegistry 类中的源代码中查看。
 *
 * @Mapper 注解针对的是一个一个的类，相当于是一个一个 Mapper.xml 文件。而一个接口一个接口的使用 @Mapper，太麻烦了，于是 @MapperScan 就应用而生了。@MapperScan 配置一个或多个包路径，自动的扫描这些包路径下的类，自动的为它们生成代理类。
 */
@Mapper
public interface OrderInfoDao {

    int create(OrderInfoEntity entity);

    /**
     * 通过id获取订单
     *
     * @param id
     * @return
     */
    OrderInfoEntity getById(@Param(value = "id") Long id);
}
