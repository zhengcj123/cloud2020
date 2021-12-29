package com.dcsyun.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhengcj
 * @create 2020-11-09 15:18
 */
@Component
public class GateWayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
       return routes.route("rote_guonei",r->r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("rote_guoji",r->r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .route("rote_mil",r->r.path("/mil").uri("http://news.baidu.com/mil"))
                .route("rote_finance",r->r.path("/finance").uri("http://news.baidu.com/finance"))

                .build();

    }

}
