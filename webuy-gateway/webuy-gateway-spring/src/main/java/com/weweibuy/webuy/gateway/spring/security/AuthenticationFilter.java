package com.weweibuy.webuy.gateway.spring.security;

import com.alibaba.fastjson.JSON;
import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author durenhao
 * @date 2019/4/21 19:17
 **/
@Slf4j
public class AuthenticationFilter implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        log.error("进入 AuthenticationFilter, path:{}", request.getPath());
        if(!headers.containsKey("Authorization")){
            log.error("权限不足");
            return write403Response(exchange);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 设置在限流过滤器之后
        return 1;
    }

    private Mono<Void> write403Response(ServerWebExchange exchange){
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        response.setStatusCode(HttpStatus.FORBIDDEN);
        return response.writeWith(Flux.just(response.bufferFactory().wrap(JSON.toJSONBytes(CommonJsonResponse.fail(CommonWebMsg.FORBIDDEN)))));
    }

}
