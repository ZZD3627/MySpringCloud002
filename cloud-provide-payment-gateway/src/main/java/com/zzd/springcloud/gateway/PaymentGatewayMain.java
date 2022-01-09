package com.zzd.springcloud.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.zzd.springcloud.payment.dao")
//此注解用于获取eureka客户端相关信息
@EnableDiscoveryClient
public class PaymentGatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(PaymentGatewayMain.class,args);
    }
}
