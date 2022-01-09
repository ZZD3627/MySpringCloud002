package com.zzd.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
//@EnableDiscoveryClient
//@MapperScan("com.zzd.springcloud.payment.dao")
public class PaymentHystrixMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8003.class,args);
    }
}
