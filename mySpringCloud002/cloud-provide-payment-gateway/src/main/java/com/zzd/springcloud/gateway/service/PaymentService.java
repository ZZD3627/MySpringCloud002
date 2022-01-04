package com.zzd.springcloud.gateway.service;

import com.zzd.springcloud.common.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id")long id);
}
