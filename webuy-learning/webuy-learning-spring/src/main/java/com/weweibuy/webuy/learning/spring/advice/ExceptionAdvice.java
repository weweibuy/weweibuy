package com.weweibuy.webuy.learning.spring.advice;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.learning.spring.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author durenhao
 * @date 2019/7/1 21:41
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = ClientException.class)
    public ResponseEntity handlerException(ClientException e) {
        log.error("出错了", e);
        return ResponseEntity.ok(CommonJsonResponse.success());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handlerException(Exception e) {
        log.error("出错了", e);
        return ResponseEntity.ok(CommonJsonResponse.success(e.getMessage()));
    }

}
