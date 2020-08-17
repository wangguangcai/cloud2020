package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MySelfRule
 * @Description:    设置ribbon自定义算法的配置累
 * @Author: wangguangcai
 * @Data: 2020/8/6 15:54
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule rule(){
        return new RandomRule();//定义算法为随机
    }
}
