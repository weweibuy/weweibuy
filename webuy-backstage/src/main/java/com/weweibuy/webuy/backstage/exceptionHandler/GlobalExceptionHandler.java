package com.weweibuy.webuy.backstage.exceptionHandler;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 16:00
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonCodeResponse handleException(Exception e){
        e.printStackTrace();
        return null;
    }

}
