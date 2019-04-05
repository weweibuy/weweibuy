package com.weweibuy.webuy.inventory.controller;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.common.eum.CommonWebMsg;
import com.weweibuy.webuy.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存服务
 * @ClassName InventoryContoller
 * @Description
 * @Author durenhao
 * @Date 2019/2/9 11:03
 **/
@RestController
@RequestMapping(value = "/inventory", produces = "application/json;charset=UTF-8")
public class InventoryContoller {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/getnum/skus")
    public CommonJsonResponse getInventoryNumBuySkuId(Long[] skuIds){
        for(int i = 0; i < skuIds.length; i++){
            if(skuIds[i] == null){
                return CommonJsonResponse.fail(CommonWebMsg.PARAM_WRONG);
            }
        }
        return inventoryService.getInventoryNumBuySkuIds(skuIds);
    }


}
