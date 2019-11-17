package com.weweibuy.webuy.learning.event.autowire;

/**
 * @author durenhao
 * @date 2019/11/8 23:16
 **/
public interface TestHandler<T extends TestEum> {


    void handler( T t);

}
