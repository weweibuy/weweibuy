package com.weweibuy.webuy.learning.event.autowire;

import lombok.extern.slf4j.Slf4j;

/**
 * @author durenhao
 * @date 2019/11/8 23:17
 **/
@Slf4j
public class TestHandlerImpl_A implements TestHandler{

    @Override
    public void handler(TestEum testEum) {
        log.info(testEum.toString());
    }
}
