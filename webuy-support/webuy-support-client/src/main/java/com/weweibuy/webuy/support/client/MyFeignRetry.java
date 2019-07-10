package com.weweibuy.webuy.support.client;

import feign.RetryableException;
import feign.Retryer;

/**
 * @author durenhao
 * @date 2019/6/20 21:50
 **/
public class MyFeignRetry implements Retryer {


    @Override
    public void continueOrPropagate(RetryableException e) {

    }

    @Override
    public Retryer clone() {
        return null;
    }
}
