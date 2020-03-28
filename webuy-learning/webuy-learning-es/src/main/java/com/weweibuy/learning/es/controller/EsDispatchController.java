package com.weweibuy.learning.es.controller;

import com.weweibuy.learning.es.model.vo.DispatchPageQueryVo;
import com.weweibuy.learning.es.service.EsDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author durenhao
 * @date 2019/8/11 9:47
 **/
@RestController
@RequestMapping("/es/dispatch")
public class EsDispatchController {

    @Autowired
    private EsDispatchService dispatchService;

    @GetMapping("/{id}")
    public Object getById(@PathVariable String id) {
        return dispatchService.getById(id);
    }


    @PostMapping("/page")
    public Object pageQuery(@RequestBody DispatchPageQueryVo pageQueryVo) {
        return dispatchService.pageSearch(pageQueryVo);
    }


}
