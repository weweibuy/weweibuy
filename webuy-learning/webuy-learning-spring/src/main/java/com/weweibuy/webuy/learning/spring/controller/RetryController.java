package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.service.RetryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/2/14 18:06
 **/
@RestController
@RequestMapping("/retry")
public class RetryController {

    private final RetryService retryService;

    public RetryController(RetryService retryService) {
        this.retryService = retryService;
    }

    @GetMapping("/test")
    public String retry(){
        return retryService.retry();
    }

}
