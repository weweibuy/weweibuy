package com.weweibuy.webuy.learning.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author durenhao
 * @date 2019/11/25 23:14
 **/
@Controller
@RequestMapping("/from")
public class FormController {


    @ResponseBody
    @RequestMapping("/test")
    public String quq(@RequestParam(name = "params", required = false) String params){
        return params;
    }

}
