package com.weweibuy.webuy.message.exception.handler;

import com.weweibuy.framework.common.core.model.dto.CommonCodeResponse;
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
    public CommonCodeResponse handleException(Exception e){
        log.error(e.getMessage());
        return CommonCodeResponse.unknownException();
    }

    @ExceptionHandler(BizException.class)
    public CommonCodeResponse handleBizException(BizException e){
        log.error(e.getMessage());
        return CommonCodeResponse.badRequestParam();
    }

}
