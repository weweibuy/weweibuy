package com.weweibuy.webuy.learning.spring.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.weweibuy.webuy.learning.spring.service.SentinelService;
import com.weweibuy.webuy.learning.spring.service.SentinelService2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/7/20 9:05
 **/
@Slf4j
@RestController
@RequestMapping("/sentinel")
public class SentinelController {


    @Autowired
    private SentinelService sentinelService;

    @Autowired
    private SentinelService2 sentinelService2;

    @RequestMapping("/test")
    public ResponseEntity sentinelTest() throws Exception{
        Entry entry = null;
        try {
            entry = SphU.entry("HelloWorld");
            Thread.sleep(100);
//            sentinelService.service();
//            sentinelService2.service();
            return ResponseEntity.ok("success");
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            log.info("流控", e1);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("fail");
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }


}
