package com.weweibuy.webuy.learning.spring.reactor;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/5/28 23:13
 **/
public interface MyMessageListener<T> {

    public void onMessage(List<String> messages);

}
