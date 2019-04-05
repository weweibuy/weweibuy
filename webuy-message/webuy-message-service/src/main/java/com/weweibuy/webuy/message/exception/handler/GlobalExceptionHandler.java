package com.weweibuy.webuy.message.exception.handler;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author durenhao
 * @Date 2018/9/23 16:00
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonJsonResponse handleException(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return null;
    }

}
