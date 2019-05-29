package com.weweibuy.webuy.learning.spring.reactor;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/5/28 22:41
 **/
public interface MyEventListener<T> {

    void onDataChunk(List<T> chunk);


    void processComplete();


}
