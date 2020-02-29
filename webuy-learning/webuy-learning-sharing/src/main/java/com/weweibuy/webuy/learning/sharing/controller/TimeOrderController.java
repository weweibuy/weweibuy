package com.weweibuy.webuy.learning.sharing.controller;

import com.weweibuy.webuy.common.model.dto.CommonCodeJsonResponse;
import com.weweibuy.webuy.common.model.dto.CommonDataJsonResponse;
import com.weweibuy.webuy.learning.sharing.model.vo.IdOffsetQueryVo;
import com.weweibuy.webuy.learning.sharing.model.vo.PageQueryVo;
import com.weweibuy.webuy.learning.sharing.service.TimeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public CommonCodeJsonResponse getHeader(PageQueryVo vo){
        return CommonDataJsonResponse.success(timeOrderService.getHeaders(vo));
    }

    @GetMapping("/sharing/page-get/id-offset")
    public CommonCodeJsonResponse getHeaderIdOffset(IdOffsetQueryVo vo){
        return CommonDataJsonResponse.success(timeOrderService.getHeadersWithId(vo));
    }

    @GetMapping("/sharing/no-sharing-page-get")
    public CommonCodeJsonResponse getNoSharingHeader(PageQueryVo vo){
        return CommonDataJsonResponse.success(timeOrderService.noSharingPageQuery(vo));
    }

    @GetMapping("/sharing/details")
    public CommonCodeJsonResponse selectDetail(String no){
        return CommonDataJsonResponse.success(timeOrderService.getDetailByOrderNo(no));
    }

}
