package com.weweibuy.webuy.gateway.spring.controller;

import com.alibaba.fastjson.JSON;
import com.weweibuy.webuy.gateway.spring.constant.GatewayRouteConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author durenhao
 * @date 2019/4/21 21:27
 **/
@RestController
@RequestMapping("/dy-route")
public class DynamicRoutesController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 把路由信息放入redis, 接下来要做的就是操作redis,来跟改路由配置
     * @return
     */
    @RequestMapping("/add-route")
    public String push(){
        RouteDefinition definition = new RouteDefinition();
        definition.setId("auth_0");
        definition.setUri(UriComponentsBuilder.fromUriString("lb://webuy-auth").build().toUri());
        definition.setOrder(1);

        RouteDefinition definition1 = new RouteDefinition();
        definition1.setId("auth_1");
        definition1.setUri(UriComponentsBuilder.fromUriString("lb://webuy-auth").build().toUri());
        definition1.setOrder(2);

        RouteDefinition definition2 = new RouteDefinition();
        definition2.setId("auth_2");
        definition2.setUri(UriComponentsBuilder.fromUriString("lb://webuy-auth").build().toUri());
        definition2.setOrder(0);




        PredicateDefinition predicate = new PredicateDefinition();
        predicate.setName("Path");
        Map<String, String> predicateParams = new HashMap<>(8);
        predicateParams.put("pattern", "/auth/**");
        predicate.setArgs(predicateParams);

        PredicateDefinition predicate1 = new PredicateDefinition();
        predicate1.setName("Method");
        Map<String, String> predicateParams1 = new HashMap<>(8);
        predicateParams1.put("method", "POST");
        predicate1.setArgs(predicateParams1);


        PredicateDefinition predicate2 = new PredicateDefinition();
        predicate2.setName("Method");
        Map<String, String> predicateParams2 = new HashMap<>(8);
        predicateParams2.put("method", "GET");
        predicate2.setArgs(predicateParams2);

        PredicateDefinition predicate3 = new PredicateDefinition();
        predicate3.setName("Host");

        Map<String, String> predicateParams3 = new HashMap<>(8);
        predicateParams3.put("pattern", "auth.weweibuy.com");
        predicate3.setArgs(predicateParams3);

        definition.setPredicates(Arrays.asList(predicate, predicate1));
        definition1.setPredicates(Arrays.asList(predicate, predicate2));
        definition2.setPredicates(Arrays.asList(predicate3, predicate1));

        // 路由
        FilterDefinition filter = new FilterDefinition();
        filter.setName("StripPrefix");
        Map<String, String> filterParams = new HashMap<>(4);
        filterParams.put("_genkey_0", "1");
        filter.setArgs(filterParams);
        // 权限
        FilterDefinition filter1 = new FilterDefinition();
        Map<String, String> filterParams1 = new HashMap<>(4);
        filter1.setName("Authentication");
        filterParams1.put("app_key", "123");
        filter1.setArgs(filterParams1);

        // 限流
        FilterDefinition filter2 = new FilterDefinition();
        filter2.setName("RequestRateLimiter");
        Map<String, String> filterParams2 = new HashMap<>(8);
        filterParams2.put("redis-rate-limiter.replenishRate", "1");
        filterParams2.put("redis-rate-limiter.burstCapacity", "10");
        filterParams2.put("key-resolver", "#{@apiKeyResolver}");
        filterParams2.put("order", "0");
        filter2.setArgs(filterParams2);


        // 这个顺序会影响过滤器的执行顺序 实现order 接口没用 !!!!!!!!!!!
        definition.setFilters(Arrays.asList(filter, filter2, filter1));
        definition1.setFilters(Arrays.asList(filter, filter2));
        definition2.setFilters(Arrays.asList(filter, filter2));
        redisTemplate.opsForHash().put(GatewayRouteConstant.GATEWAY_ROUTES, "auth_0", JSON.toJSONString(definition));
        redisTemplate.opsForHash().put(GatewayRouteConstant.GATEWAY_ROUTES, "auth_1", JSON.toJSONString(definition1));
        redisTemplate.opsForHash().put(GatewayRouteConstant.GATEWAY_ROUTES, "auth_2", JSON.toJSONString(definition2));

        return "success";

    }

}
