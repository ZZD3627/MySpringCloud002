package com.zzd.springcloud.order.order.controller;

import com.zzd.springcloud.common.pojo.CommonResult;
import com.zzd.springcloud.common.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    //调用支付订单服务端的ip+端口号
//    public static final String PAYMENT_URL = "mcroservice-payment:8001";
    /**
        TODO:在使用eureaka中的Application名称访问server的时候遇到了
          出现的原因是：resttemplate注入的时候需要加上@LoadBalanced注解
         参考：https://blog.csdn.net/rumenxiaobaidog/article/details/82625857

        Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception
        [Request processing failed; nested exception is org.springframework.web.client.ResourceAccessException:
        I/O error on GET request for "http://MCROSERVICE-PAYMENT/payment/get/1": MCROSERVICE-PAYMENT;
        nested exception is java.net.UnknownHostException: MCROSERVICE-PAYMENT] with root cause
     */
    public static final String PAYMENT_URL = "MCROSERVICE-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;

    //创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject("http://" + PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    //获取id获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://" + PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}