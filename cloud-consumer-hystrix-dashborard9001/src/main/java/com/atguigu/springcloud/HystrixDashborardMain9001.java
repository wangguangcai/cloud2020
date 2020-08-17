package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName: HystrixDashborard9001
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/10 8:52
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashborardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashborardMain9001.class,args);
    }
}
