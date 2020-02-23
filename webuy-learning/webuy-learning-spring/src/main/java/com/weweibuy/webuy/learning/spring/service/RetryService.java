package com.weweibuy.webuy.learning.spring.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2020/2/14 18:07
 **/
@Service
public class RetryService {

    @Retryable
    public String retry() {
        if (true) {
            throw new RuntimeException();
        }
        return "success";
    }

}
