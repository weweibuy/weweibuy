package com.weweibuy.learning.webflux.config;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.ipc.netty.resources.LoopResources;

/**
 * @author durenhao
 * @date 2019/9/30 20:26
 **/
@Configuration
public class WebFluxConfig {

    @Bean
    public ReactiveWebServerFactory reactiveWebServerFactory() {
        NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
        factory.addServerCustomizers(builder -> builder.loopResources(LoopResources.create("my-http", 20, true)));
        return factory;
    }

}
