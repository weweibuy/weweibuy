package com.weweibuy.inventory.service;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.inventory.common.model.po.WebuyInventory;

import java.util.List;

/**
 * @ClassName InvertoryService
 * @Description
 * @Author durenhao
 * @Date 2019/2/9 11:07
 **/

public interface InventoryService {

    CommonJsonResponse<List<WebuyInventory>> getInventoryNumBuySkuIds(Long[] skuId);

}
