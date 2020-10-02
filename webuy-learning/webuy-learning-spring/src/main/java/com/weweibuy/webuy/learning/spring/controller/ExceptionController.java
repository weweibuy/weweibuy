package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.webuy.learning.spring.exception.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/7/1 21:32
 **/
@Slf4j
@RestController
public class ExceptionController {

    @RequestMapping("/exception")
    public ResponseEntity test01() throws InterruptedException {
        Thread.sleep(100);
        if (true) {
            throw new ClientException("业务处理出错了");
        }
        return ResponseEntity.ok(CommonDataResponse.success());
    }


    @RequestMapping("/no-exception")
    public ResponseEntity test02() throws InterruptedException {
        Thread.sleep(100);
        log.info("处理业务");
        return ResponseEntity.ok(CommonDataResponse.success());
    }


}
