package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: OrderHystrixController
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/7 14:46
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethond")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result=paymentHystrixService.paymentInfo_ok(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
//        log.info("*******服务调用失败进行服务降级 ");
        int age=10/0;
        log.info("*******服务调用超时进行服务降级 ");
        String result=paymentHystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "我是消费者80，支付系统繁忙请于10秒钟后再试或者检查自己是否运行出错";
    }

    //全局fallback方法
    public String payment_Global_FallbackMethond(){
        return "Global异常处理信息，请稍后再试o(╥﹏╥)o";
    }
}
