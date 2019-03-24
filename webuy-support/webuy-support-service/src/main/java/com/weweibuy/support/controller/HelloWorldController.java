package com.weweibuy.support.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWorldController
 * @Description
 * @Author durenhao
 * @Date 2019/2/21 22:25
 **/
@RestController
@Slf4j
public class HelloWorldController {

    @RequestMapping("/hello/{id}")
    @HystrixCommand(fallbackMethod = "noHello")
    public String hello(@PathVariable String id) throws InterruptedException {
        log.info(".............");
        Thread.sleep(5000);
        System.err.println(" biz  action ....");
        log.info("xxxx");
        return "hello....";
    }


    @RequestMapping("/hello/normal")
    public String normalHello() throws InterruptedException {
        log.info(".............");
        Thread.sleep(3000);
        throw new RuntimeException();
    }

    @RequestMapping("/hello2/{id}")
    @HystrixCommand(groupKey = "report", commandKey = "123", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "2"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")},
            fallbackMethod = "noHello")
    public String hello2(@PathVariable String id) throws InterruptedException {
        log.info(".............");
        Thread.sleep(5000);
        log.info("xxxx");
        return "hello2....";
    }

    /**
     * HystrixCommand SEMAPHORE模式下 也需要指定超时设置
     * commandKey 是的HystrixCommand 在SEMAPHORE模式下 下连个相同的commandKey 的SEMAPHORE 是共用(累加)的
     * 不同的 commandKey 相同 groupKey SEMAPHORE是分开计算的
     * 即使相同的groupKey 也得每次都指定HystrixProperty 这样做可以灵活的对每个方法进行控制，但是大多重复
     * TODO 目前除了default 的配置没有找到其他的 可以共用的或全局的 HystrixCommand 设置
     * @param id
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/hello3/{id}")
    @HystrixCommand(groupKey = "report", commandKey = "123", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "2"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")},
            fallbackMethod = "noHello")
    public String hello3(@PathVariable String id) throws InterruptedException {
        log.info(".............");
        Thread.sleep(5000);
        log.info("xxxx");
        return "hello3....";
    }

    @Async
    public String noHello(String id){
        log.error("fall back");
        return "no.. hello.. " + id;
    }

    public String noHello2(String id){
        log.error("fall back");
        return "no.. hello2.. " + id;
    }


}
