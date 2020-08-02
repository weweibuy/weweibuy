package com.weweibuy.webuy.learning.spring.tx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/8/2 17:43
 **/
@RestController
@RequestMapping("/tx")
public class TxController {

    private final SampleTxService sampleTxService;

    public TxController(SampleTxService sampleTxService) {
        this.sampleTxService = sampleTxService;
    }

    @GetMapping
    public String biz(){
        return sampleTxService.biz();
    }

}
