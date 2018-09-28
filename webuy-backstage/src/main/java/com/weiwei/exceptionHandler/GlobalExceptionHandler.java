package com.weiwei.exceptionHandler;

import com.weiwei.dto.WebResult;
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
    public WebResult handleException(Exception e){
        e.printStackTrace();
        return null;
    }

}
