package com.zzd.springcloud.myconfig.controller;

import com.zzd.springcloud.common.pojo.CommonResult;
import com.zzd.springcloud.common.pojo.Payment;
import com.zzd.springcloud.myconfig.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
/**
 * TODO:日志级别感觉没有设置成功，待后面有时间再继续研究
 */
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult result = paymentService.queryById(id);
        return result;
    }

    @GetMapping("/consumer/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException {
        return paymentService.PaymentFeignTimeOut();
    }

}
