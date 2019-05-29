package com.weweibuy.webuy.learning.spring.model;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ResponseVoTest {

    @Test
    public void test(){
        String json = "{\"code\":\"12\", \"msg\":\"QAZ\"}";
        ResponseVo responseVo = JSON.parseObject(json, ResponseVo.class);
        System.err.println(responseVo);

    }


    @Test
    public void test02(){
        Flux.just("a", "b")
                .zipWith(Flux.just("c", "d"))
                .subscribe(System.out::println);
    }

    @Test
    public void test03(){

        Flux.just("red", "white", "blue")
                .flatMap(value ->
                                Mono.just(value.toUpperCase())
                                        .map(v -> Mono.just(v + 11))
//                                        .subscribe(System.err::println))
                                        .subscribeOn(Schedulers.parallel()),
                        2)
                .subscribe(value -> {
                    log.info("Consumed: " + value);
                });
    }

}