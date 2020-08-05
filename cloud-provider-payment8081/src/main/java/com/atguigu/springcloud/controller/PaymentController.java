package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/")
    public String index(){
        return "hello world!!";
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("*******插入结果："+result);

        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(500,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*******查询结果："+payment+"*****");

        if(payment!=null){
            return new CommonResult(200,"查询数据库成功,serverPort: "+serverPort,payment);
        }else{
            return new CommonResult(500,"没有对应记录，查询ID："+id,null);
        }
    }


    @RequestMapping(value = "/getRedis")
    public void redisTest(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //设置密码
        jedis.auth("Kaixin1.");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        jedis.set("ceshi","123123");
        System.out.println(jedis.get("ceshi"));

    }


}
