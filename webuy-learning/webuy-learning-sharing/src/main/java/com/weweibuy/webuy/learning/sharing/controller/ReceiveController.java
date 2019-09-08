package com.weweibuy.webuy.learning.sharing.controller;

import com.weweibuy.webuy.learning.sharing.service.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author durenhao
 * @date 2019/9/7 22:52
 **/
@RestController
@RequestMapping("/receive")
public class ReceiveController {


    private Executor executor = Executors.newFixedThreadPool(5);

    @Autowired
    private ReceiveService receiveService;

    @PostMapping("/add")
    public String addDispatch() {
        receiveService.addHeaderAndDetail();
        return "success";
    }

    @PostMapping("/batch-add")
    public String batchAddDispatch(Integer count) {
        if (count == null) {
            count = 10000;
        }
        Flux.range(0, count)
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(i -> receiveService.addHeaderAndDetail())
                .sequential()
                .subscribe();
        return "success";
    }




}
