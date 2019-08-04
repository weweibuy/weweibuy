package com.weweibuy.learning.es.controller;

import com.weweibuy.learning.es.service.EsTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/8/4 10:35
 **/
@RestController
@RequestMapping("/es/test")
public class EsTestController {


    @Autowired
    private EsTestService service;

    @GetMapping("/get/{id}")
    public Object getById(@PathVariable("id") Long id) {
        return service.searchById(id);
    }


}
