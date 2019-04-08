package com.weweibuy.webuy.message.exception;

/**
 * @author durenhao
 * @date 2019/4/8 23:42
 **/
public class BizException extends RuntimeException {

    public BizException(){
        super();
    }

    public BizException(String msg){
        super(msg);
    }

    public BizException(String msg, Throwable e){
        super(msg, e);
    }

}
