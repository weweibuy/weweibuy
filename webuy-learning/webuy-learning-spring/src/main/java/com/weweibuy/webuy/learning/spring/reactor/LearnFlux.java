package com.weweibuy.webuy.learning.spring.reactor;

import reactor.core.publisher.Flux;

/**
 * @author durenhao
 * @date 2019/4/23 23:32
 **/
public class LearnFlux {


    public void createFlux() {
        Flux<Object> flux = Flux.just(Flux.just("Hello", "World").subscribe(System.out::println));
    }

}
