package com.weweibuy.webuy.product.client;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.product.common.model.form.WebuyItemForm;
import com.weweibuy.webuy.product.common.model.po.WebuyItem;
import com.weweibuy.webuy.product.client.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName ProductClient
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 10:15
 **/
@FeignClient(value = "webuy-product", fallbackFactory = ProductClientFallBack.class)
public interface ProductClient  {

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    CommonJsonResponse<WebuyItem> getItem(@PathVariable("id") Long id);

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    CommonJsonResponse addItem(@RequestBody WebuyItemForm webuyItem);

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    CommonJsonResponse delItem(@PathVariable("id") Long id);

}
