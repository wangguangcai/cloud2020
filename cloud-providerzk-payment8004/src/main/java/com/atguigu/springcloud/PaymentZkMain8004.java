package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: PaymentMain8004
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/6 9:26
 **/
@SpringBootApplication
@EnableDiscoveryClient   //该注解用于向使用consul或者zookeeper作为注册中心审时注册服务
public class PaymentZkMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZkMain8004.class,args);
    }
}
