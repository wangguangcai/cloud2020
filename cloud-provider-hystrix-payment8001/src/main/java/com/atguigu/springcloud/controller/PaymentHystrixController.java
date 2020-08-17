package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentHystrixController
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/7 14:05
 **/
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_ok(id);
        log.info("********result: "+result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_timeout(id);
        log.info("********result: "+result);
        return result;
    }

    //=====服务熔断

    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentCircuitBreaker(id);
        log.info("********result: "+result);
        return result;
    }
}
