package com.weweibuy.webuy.learning.sharing.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.learning.sharing.model.vo.PageQueryVo;
import com.weweibuy.webuy.learning.sharing.service.TimeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2019/6/16 10:41
 **/
@RestController
public class TimeOrderController {

    @Autowired
    private TimeOrderService timeOrderService;

    @RequestMapping("/sharing/insert")
    public String insert(Boolean batch) {
        if(batch){
            timeOrderService.sharingBatchInsert();
        }else {
            timeOrderService.sharingInsert();
        }
        return "success";
    }

    @RequestMapping("/sharing/no-sharing-batch-insert")
    public String noSharingBatchInsert() {
        timeOrderService.noSharingBatchInsert();
        return "success";
    }


    @GetMapping("/sharing/page-get")
    public CommonJsonResponse getHeader(@RequestBody PageQueryVo vo){
        return CommonJsonResponse.success(timeOrderService.getHeaders(vo));
    }

    @GetMapping("/sharing/no-sharing-page-get")
    public CommonJsonResponse getNoSharingHeader(@RequestBody PageQueryVo vo){
        return CommonJsonResponse.success(timeOrderService.noSharingPageQuery(vo));
    }

    @GetMapping("/sharing/details")
    public CommonJsonResponse selectDetail(String no){
        return CommonJsonResponse.success(timeOrderService.getDetailByOrderNo(no));
    }

}
