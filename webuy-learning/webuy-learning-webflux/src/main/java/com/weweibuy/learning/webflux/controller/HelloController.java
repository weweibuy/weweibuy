package com.weweibuy.learning.webflux.controller;

import com.weweibuy.learning.webflux.model.dto.JsonResponseDto;
import com.weweibuy.learning.webflux.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author durenhao
 * @date 2019/9/30 20:25
 **/
@Slf4j
@RestController
@RequestMapping("/webflux")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public ResponseEntity<JsonResponseDto> test01() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new JsonResponseDto());
    }


    @GetMapping("/hello2")
    public Mono<ResponseEntity<JsonResponseDto>> test02() throws InterruptedException {
        log.info("收到请求");
        return Mono.just(ResponseEntity.ok(JsonResponseDto.success("")));
    }


}
