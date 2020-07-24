package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CommonResult
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/7/21 20:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code,String message){

        this(code,message,null);
    }
}
