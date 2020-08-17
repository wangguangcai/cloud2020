package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName: PaymentFallBackService
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/7 16:59
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "----------PaymentFallbackService fallback----paymentInfo_ok,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "----------PaymentFallbackService fallback-----paymentInfo_timeout,o(╥﹏╥)o";
    }
}
