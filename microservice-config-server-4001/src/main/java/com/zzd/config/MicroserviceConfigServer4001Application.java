package com.zzd.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class MicroserviceConfigServer4001Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServer4001Application.class, args);
    }
}
