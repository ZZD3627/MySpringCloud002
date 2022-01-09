package com.zzd.springcloud.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zzd.springcloud.payment.dao")
public class PaymentMain02 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain02.class,args);
    }
}
