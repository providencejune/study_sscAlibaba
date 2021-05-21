package com.guigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@MapperScan("com.guigu.springcloud.**.dao.**")
public class OrderInfoApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderInfoApplication.class, args);
    }
}
