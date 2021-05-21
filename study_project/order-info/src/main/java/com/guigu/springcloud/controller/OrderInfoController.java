package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.OrderInfoEntity;
import com.guigu.springcloud.resultentity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderInfoController {

    public static final String PYAMENT_URL = "http://CLOUD-ORDER-PAYMENT";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/get_orderinfo")
    public CommonResult<OrderInfoEntity> getPayment(Long id) {
        return restTemplate.getForObject(PYAMENT_URL + "/order/get/" + id, CommonResult.class);
    }
}
