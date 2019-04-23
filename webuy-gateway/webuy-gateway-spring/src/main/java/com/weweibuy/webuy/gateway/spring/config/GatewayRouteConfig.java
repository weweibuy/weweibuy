package com.weweibuy.webuy.gateway.spring.config;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import com.weweibuy.webuy.gateway.spring.routes.dynamic.RedisStoreDynamicRoutes;
import com.weweibuy.webuy.gateway.spring.security.AuthenticationGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author durenhao
 * @date 2019/4/20 23:29
 **/
@Configuration
public class GatewayRouteConfig {

    @Autowired
    private AuthenticationGatewayFilterFactory authenticationGatewayFilterFactory;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        // GatewayFilterSpec 的顺序都是0
        RouteLocator routeLocator = builder.routes()
                .route("learn-spring-id-01", route -> route
                        .path("/learn-spring/**")
                        .filters(filter -> filter
                                .rewritePath("/learn-spring", "/api/v1")
                                .hystrix(command -> command
                                        .setName("slow").setSetter(slowHystrixCommand())
                                        .setFallbackUri("forward:/default-fallback"))
                                .requestRateLimiter(limit -> limit
                                        .setRateLimiter(redisRateLimiter())
                                        .setKeyResolver(apiKeyResolver()))
                                .filter(authenticationGatewayFilterFactory))
                        .uri("lb://learning-spring")).build();
        return routeLocator;
    }


    @Bean
    public RedisStoreDynamicRoutes redisStoreDynamicRoutes(){
        return new RedisStoreDynamicRoutes();
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 2);
    }

    @Bean
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    public HystrixObservableCommand.Setter slowHystrixCommand() {
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("group-test");
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("/12");

        HystrixCommandProperties.Setter propertiesSetter = HystrixCommandProperties.Setter()
                .withCircuitBreakerEnabled(true)
                .withExecutionIsolationThreadInterruptOnTimeout(true)
                .withExecutionTimeoutEnabled(true)
                .withExecutionTimeoutInMilliseconds(15000)
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

        return HystrixObservableCommand.Setter
                .withGroupKey(groupKey)
                .andCommandPropertiesDefaults(propertiesSetter)
                .andCommandKey(commandKey);
    }

}


