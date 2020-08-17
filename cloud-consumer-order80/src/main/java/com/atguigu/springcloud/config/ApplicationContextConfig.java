package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/7/21 20:35
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//@LoadBalanced注解赋予了RestTemplate实现负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
