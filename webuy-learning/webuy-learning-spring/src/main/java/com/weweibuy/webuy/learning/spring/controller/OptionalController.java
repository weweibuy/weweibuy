package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.model.vo.OptionalVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/8/12 21:37
 **/
@Slf4j
@RestController
@RequestMapping("/optional")
public class OptionalController {

    @GetMapping("/get")
    public Object getOpt(OptionalVo optionalVo) {
        log.info("opt: {}", optionalVo);
        return optionalVo;
    }


}
