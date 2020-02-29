package com.weweibuy.webuy.message.exception.handler;

import com.weweibuy.webuy.common.model.dto.CommonCodeJsonResponse;
import com.weweibuy.webuy.message.exception.BizException;
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
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonCodeJsonResponse handleException(Exception e){
        log.error(e.getMessage());
        return CommonCodeJsonResponse.unknownException();
    }

    @ExceptionHandler(BizException.class)
    public CommonCodeJsonResponse handleBizException(BizException e){
        log.error(e.getMessage());
        return CommonCodeJsonResponse.badRequestParam();
    }

}
