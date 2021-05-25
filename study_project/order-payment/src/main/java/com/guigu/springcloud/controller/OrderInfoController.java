package com.guigu.springcloud.controller;

import com.guigu.springcloud.entity.OrderInfoEntity;
import com.guigu.springcloud.resultentity.CommonResult;
import com.guigu.springcloud.service.OrderInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;
    @Value("${server.port}")
    private String servePort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/order/create")
    public CommonResult<Integer> createOrderInfo(OrderInfoEntity entity) {
        int rs = orderInfoService.create(entity);
        if (rs > 0) {
            log.info("**新增订单结果：" + rs);
            return new CommonResult(200, "", rs);
        } else {
            return new CommonResult(500, "新增失败", null);
        }
    }

    @GetMapping(value = "/order/get/{id}")
    public CommonResult<OrderInfoEntity> getOrderInfoById(@PathVariable(value = "id") Long id) {
        OrderInfoEntity rs = orderInfoService.getById(id);
        log.info("服务端口:" + servePort + ";获取对应订单：" + rs);
        return new CommonResult(200, "服务端口:" + servePort, rs);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String serve : services) {
            log.info("****element:" + serve);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
