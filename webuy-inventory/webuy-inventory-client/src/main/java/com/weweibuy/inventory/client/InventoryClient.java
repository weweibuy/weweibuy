package com.weweibuy.inventory.client;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.inventory.client.fallback.InventoryFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName InventoryClient
 * @Description
 * @Author durenhao
 * @Date 2019/2/9 11:37
 **/
@FeignClient(value = "webuy-inventory", fallbackFactory = InventoryFallback.class)
public interface InventoryClient {

    @RequestMapping(value = "/getnum/skus", method = RequestMethod.GET)
    CommonJsonResponse getInventoryNumBuySkuId(@RequestParam("skuIds") Long[] skuIds);

}
