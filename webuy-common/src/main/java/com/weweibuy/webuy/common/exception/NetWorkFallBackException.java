package com.weweibuy.webuy.common.exception;

/**
 * @author durenhao
 * @date 2019/4/14 22:10
 **/
public class NetWorkFallBackException extends RuntimeException {

    public NetWorkFallBackException() {
    }

    public NetWorkFallBackException(String msg) {
        super(msg);
    }

    public NetWorkFallBackException(String msg, Throwable e) {
        super(msg, e);
    }


}
