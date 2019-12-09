package com.weweibuy.webuy.learning.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author durenhao
 * @date 2019/11/25 23:14
 **/
@Slf4j
@Controller
@RequestMapping("/from")
public class FormController {


    @ResponseBody
    @PostMapping("/test")
    public String quq(@RequestParam(name = "params", required = false) String params){
        log.info("参数: {}", params);
        return params;
    }

}
