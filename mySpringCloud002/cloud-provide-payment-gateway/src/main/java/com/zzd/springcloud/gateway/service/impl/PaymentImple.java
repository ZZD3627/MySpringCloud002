package com.zzd.springcloud.gateway.service.impl;

import com.zzd.springcloud.gateway.dao.PaymentDao;
import com.zzd.springcloud.gateway.service.PaymentService;
import com.zzd.springcloud.common.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentImple implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryById(long id) {
        return paymentDao.queryById(id);
    }
}
