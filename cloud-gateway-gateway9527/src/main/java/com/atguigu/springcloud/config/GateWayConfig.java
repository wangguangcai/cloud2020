package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: GateWayConfig
 * @Description:
 * @Author: wangguangcai
 * @Data: 2020/8/11 13:18
 **/
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为path_route_atguigu的路由规则
     * 当前访问地址http://localhost:9527/guonei时会自动转发到地址http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}

