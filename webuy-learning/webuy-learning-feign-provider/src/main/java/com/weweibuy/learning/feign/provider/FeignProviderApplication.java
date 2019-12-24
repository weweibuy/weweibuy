package com.weweibuy.learning.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author durenhao
 * @date 2019/12/24 21:27
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class FeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class, args);
    }


}
