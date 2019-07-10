package com.weweibuy.webuy.learning.spring.exception;

import lombok.NoArgsConstructor;

/**
 * @author durenhao
 * @date 2019/7/1 21:38
 **/
@NoArgsConstructor
public class ClientException extends RuntimeException {

    public ClientException(String msg){
        super(msg);
    }

}
