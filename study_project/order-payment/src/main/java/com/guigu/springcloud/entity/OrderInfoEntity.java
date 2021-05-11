package com.guigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoEntity {

    private Long id;
    private String orderCode;
    private Date createTime;
    private Date updateTime;
}
