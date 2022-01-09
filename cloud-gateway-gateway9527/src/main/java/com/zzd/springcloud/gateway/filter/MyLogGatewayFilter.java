package com.zzd.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************come in MyLogGatewayFilter " + LocalDateTime.now());
        //判断是否携带uname的key
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        //非法用户请离开
        if (uname == null) {
            log.info("************用户名为null，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        //合法用户进行下一个过滤链进行过滤验证
        return chain.filter(exchange);
    }

    //这个0数字代表加载过滤器的顺序，就是越小优先级越高，因为是全局的，所以必须是第一位的。
    @Override
    public int getOrder() {
        return 0;
    }
}
