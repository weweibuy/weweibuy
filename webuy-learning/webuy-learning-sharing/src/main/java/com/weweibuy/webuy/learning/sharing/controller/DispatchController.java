package com.weweibuy.webuy.learning.sharing.controller;

import com.baidu.fsg.uid.UidGenerator;
import com.weweibuy.webuy.learning.sharing.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/8/2 22:57
 **/
@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @Autowired
    private UidGenerator uidGenerator;

    @PostMapping("/add")
    public String addDispatch(){
        dispatchService.addHeaderAndDetail();
        return "success";
    }


}
