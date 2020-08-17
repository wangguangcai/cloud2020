package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName: PaymentConsulController
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/6 14:23
 **/
@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentZk(){
        return "springcloud with consul :"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
