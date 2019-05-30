package com.weweibuy.webuy.learning.spring.reactor;

/**
 * @author durenhao
 * @date 2019/5/28 22:41
 **/
public interface MyEventListener<T> {

    void onDataChunk(T chunk);


    void processComplete();


}
