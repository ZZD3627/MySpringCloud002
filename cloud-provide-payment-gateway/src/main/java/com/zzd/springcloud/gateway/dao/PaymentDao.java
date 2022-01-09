package com.zzd.springcloud.gateway.dao;

import com.zzd.springcloud.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {

    int create(Payment payment);
    Payment queryById(@Param("id")long id);

}
