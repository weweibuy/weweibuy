package com.weweibuy.webuy.gateway.spring.security;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author durenhao
 * @date 2019/4/23 22:17
 **/
@Slf4j
@Component
public class AuthenticationGatewayFilterFactory extends AbstractGatewayFilterFactory implements GatewayFilter, Ordered {


    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return action(exchange, chain);
        };
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return action(exchange, chain);
    }

    public Mono<Void> action(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        log.error("进入 AuthenticationFilter, path:{}", request.getPath());
        if (!headers.containsKey("Authorization")) {
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

    private Mono<Void> write403Response(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        response.setStatusCode(HttpStatus.FORBIDDEN);
        return response.writeWith(Flux.just(response.bufferFactory()
                .wrap(JackJsonUtils.writeAsByte(CommonCodeResponse.forbidden()))));
    }

}
