package com.zzd.springcloud.gateway.service;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker( Integer id);
}
