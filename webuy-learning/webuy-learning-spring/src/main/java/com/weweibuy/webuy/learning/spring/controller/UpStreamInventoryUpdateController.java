/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.model.UpStreamInventoryUpdateRequestVo;
import com.weweibuy.webuy.learning.spring.model.YunjuAcceptDispatchReceiptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/6/24 20:25
 **/
@Slf4j
@RestController
public class UpStreamInventoryUpdateController {

    @PostMapping("/UpStreamInventoryUpdate")
    public ResponseEntity update(UpStreamInventoryUpdateRequestVo vo,
                                 @RequestHeader(value = "Host") String host, @RequestHeader(value = "Content-Type") String contentType) throws InterruptedException {
        log.error("请求Host: {}; Content-Type: {}; 数据: {}", host, contentType,vo);
        return ResponseEntity.ok(new YunjuAcceptDispatchReceiptResponse());
    }


}
