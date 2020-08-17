package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PaymentHystrixService
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/7 13:57
 **/
@Service
public class PaymentHystrixService {

    //============服务降级
    /**
     * @Description:  正常访问，OK
     * @param id
     * @return: java.lang.String
     * @Author: wangguangcai
     * @Date: 2020/8/7 13:59
     */
    public String paymentInfo_ok(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_ok,id: "+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(Integer id){
//        System.out.println("*******服务运行错误进行降级");
//        int age=10/0;
        int timenumber=5;
        try {
            System.out.println("********服务超时进行降级");
            TimeUnit.SECONDS.sleep(timenumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+"  paymentInfo_ok,id: "+id+"\t"+"O(∩_∩)O哈哈~"+"耗时(秒)："+timenumber;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池： "+Thread.currentThread().getName()+"  8001服务繁忙或者运行报错，请稍后再试,id: "+id+"\t"+"o(╥﹏╥)o";
    }


    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("********id  不能为负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){

        return "id 不能为负数，请稍后再试。   o(╥﹏╥)o  id："+id;
    }


}
