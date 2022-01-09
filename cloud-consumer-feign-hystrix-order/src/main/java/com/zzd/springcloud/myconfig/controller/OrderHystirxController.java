package com.zzd.springcloud.myconfig.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zzd.springcloud.myconfig.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentHystrixService.payment_CircuitBreaker(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
//    //TODO：消费端服务降级处理  --可以在非特殊业务的时候，使用全局服务降级方法，降低代码膨胀问题
    @HystrixCommand //默认的fallback注解，测试全局服务降级
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    //服务降级的兜底的方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者8300,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o,id:" + id;

    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }


}
