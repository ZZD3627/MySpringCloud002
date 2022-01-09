package com.zzd.springcloud.myconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //激活Feign的注解  需要加到主启动类上
@EnableCircuitBreaker //断路器
public class OrderHystrixMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain.class, args);
    }
}
