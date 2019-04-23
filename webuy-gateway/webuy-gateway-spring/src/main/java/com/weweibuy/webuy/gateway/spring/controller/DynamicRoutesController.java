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

        PredicateDefinition predicate = new PredicateDefinition();
        predicate.setName("Path");
        Map<String, String> predicateParams = new HashMap<>(8);
        predicateParams.put("pattern", "/auth/**");
        predicate.setArgs(predicateParams);

        definition.setPredicates(Arrays.asList(predicate));

        FilterDefinition filter = new FilterDefinition();
        filter.setName("StripPrefix");
        Map<String, String> filterParams = new HashMap<>(4);
        filterParams.put("_genkey_0", "1");
        filter.setArgs(filterParams);

        FilterDefinition filter1 = new FilterDefinition();
        filter1.setName("Authentication");


        definition.setFilters(Arrays.asList(filter, filter1));

        redisTemplate.opsForHash().put(GatewayRouteConstant.GATEWAY_ROUTES, "auth_0", JSON.toJSONString(definition));

        return "success";

    }

}
