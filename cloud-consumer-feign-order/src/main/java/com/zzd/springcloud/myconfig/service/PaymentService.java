package com.zzd.springcloud.myconfig.service;

import com.zzd.springcloud.common.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@ComponentScan
@FeignClient(value ="mcroservice-payment")//使用Feign
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id);
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException;

}
