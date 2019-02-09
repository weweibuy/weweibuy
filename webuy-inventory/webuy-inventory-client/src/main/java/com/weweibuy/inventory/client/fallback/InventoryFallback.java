package com.weweibuy.inventory.client.fallback;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.common.eum.CommonWebMsg;
import com.weweibuy.inventory.client.InventoryClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName InventoryFallback
 * @Description
 * @Author durenhao
 * @Date 2019/2/9 11:38
 **/
@Component
public class InventoryFallback implements FallbackFactory<InventoryClient> {

    @Override
    public InventoryClient create(Throwable throwable) {
        return new InventoryClient() {
            @Override
            public CommonJsonResponse getInventoryNumBuySkuId(Long[] skuIds) {
                return CommonJsonResponse.fail(CommonWebMsg.FALL_BACK);
            }
        };
    }
}
