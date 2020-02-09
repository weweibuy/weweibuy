package com.weweibuy.webuy.learning.spring.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/1/31 14:05
 **/
@RestController
@RequestMapping("/client")
public class RemoveClientController {

    private final EurekaClient eurekaClient;

    private final DiscoveryClient discoveryClient;

    public RemoveClientController(EurekaClient eurekaClient, DiscoveryClient discoveryClient) {
        this.eurekaClient = eurekaClient;
        this.discoveryClient = discoveryClient;
    }


    @GetMapping("/info")
    public Object info() {
        return discoveryClient.getServices();
    }


    @DeleteMapping()
    public Object delete(){
        eurekaClient.shutdown();
        return "success";

    }

}
