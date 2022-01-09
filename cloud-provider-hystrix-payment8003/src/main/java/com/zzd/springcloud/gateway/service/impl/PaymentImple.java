package com.zzd.springcloud.gateway.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zzd.springcloud.gateway.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentImple implements PaymentService {
//    @Autowired
//    private PaymentDao paymentDao;

    /**
     * 正常访问，去掉了请求数据库
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 超时访问，直接设置3秒暂停
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    /*
    TODO：会发生服务降级的情况，在consumer访问的时候遇到了访问超时的一个情况，估计是访问超过了2秒，出现服务降级的情况时，会有异常爆出
           --可以在非特殊业务的时候，使用全局服务降级方法，降低代码膨胀问题
     */
    public String paymentInfo_TimeOut(Integer id) {
        //当延时超过2秒的时候，consumer就会抱一个超时的异常
        int timeNumber = 5;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id + "\t" +
                "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    /**
     * 超时访问兜底
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {

        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id:" + id + "\t" +
                "系统繁忙，请稍后再试****o(╥﹏╥)o";
    }
}
