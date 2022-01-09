package com.zzd.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${port}")
    private String port; //指的是GitHub中的port

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPort")
    public String getPort() {
        return "测试你访问的yml文件的端口是：【"+port+"】 ，【serverPort："+serverPort+"】";
    }


}
