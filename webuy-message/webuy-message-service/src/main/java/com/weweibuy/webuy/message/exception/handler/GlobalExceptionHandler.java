package com.weweibuy.webuy.message.exception.handler;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
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
    public CommonJsonResponse handleException(Exception e){
        log.error(e.getMessage());
        return CommonJsonResponse.fail(CommonWebMsg.FAIL);
    }

    @ExceptionHandler(BizException.class)
    public CommonJsonResponse handleBizException(BizException e){
        log.error(e.getMessage());
        return CommonJsonResponse.fail(CommonWebMsg.FAIL);
    }

}
