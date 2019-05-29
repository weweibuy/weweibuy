package com.weweibuy.webuy.learning.spring.reactor;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/5/28 23:02
 **/
public interface SingleThreadEventListener<T> {

    public void onDataChunk(List<String> chunk);

    public void processComplete();

    public void processError(Throwable e);

}
