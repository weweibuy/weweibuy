package com.weweibuy.webuy.gateway.spring.routes.dynamic;

import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import com.weweibuy.webuy.gateway.spring.constant.GatewayRouteConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/4/21 20:16
 **/
public class RedisStoreDynamicRoutes implements RouteDefinitionRepository {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();


        redisTemplate.opsForHash().values(GatewayRouteConstant.GATEWAY_ROUTES).stream()
                .forEach(routeDefinition -> routeDefinitions.add(JackJsonUtils.readValue(routeDefinition.toString(), RouteDefinition.class)));

        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(r -> {
            redisTemplate.opsForHash().put(GatewayRouteConstant.GATEWAY_ROUTES, r.getId(), JackJsonUtils.write(r));
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
        return routeId.flatMap(id -> {
            if (opsForHash.get(GatewayRouteConstant.GATEWAY_ROUTES, id) != null) {
                opsForHash.delete(GatewayRouteConstant.GATEWAY_ROUTES, id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new NotFoundException("RouteDefinition not found: " + routeId)));
        });
    }
}
