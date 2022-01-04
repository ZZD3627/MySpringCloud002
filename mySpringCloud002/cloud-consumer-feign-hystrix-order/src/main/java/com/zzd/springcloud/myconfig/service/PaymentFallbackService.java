package com.zzd.springcloud.myconfig.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall  paymentInfo_OK 服务器出现故障,o(╥﹏╥)o--id:" + id;
    }

    @Override
    public String payment_CircuitBreaker(Integer id) {
        return "这里是演示服务熔断，暂不需要处理";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall  paymentInfo_TimeOut 服务器出现故障,o(╥﹏╥)o--id:" + id;
    }
}
