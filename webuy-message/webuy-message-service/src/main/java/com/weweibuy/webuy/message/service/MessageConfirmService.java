package com.weweibuy.webuy.message.service;

/**
 * @author durenhao
 * @date 2019/4/10 23:01
 **/
public interface MessageConfirmService {

    /**
     * 与上游确认
     */
    void confirmToUpstream();


    /**
     * 与下游确认
     */
    void confirmToDownstream();
}
