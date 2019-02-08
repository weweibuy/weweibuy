package com.weweibuy.controller;

import com.weweibuy.dto.CommonJsonResponse;
import com.weweibuy.product.client.ProductClient;
import com.weweibuy.product.common.eum.ProductWebMsgAndCode;
import com.weweibuy.product.common.model.form.WebuyItemForm;
import com.weweibuy.product.common.model.po.WebuyItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @ClassName ProductController
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 18:46
 **/
@Slf4j
@RestController
@RequestMapping(produces="application/json;charset=UTF-8")
public class ProductController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/product/{id}")
    public CommonJsonResponse<WebuyItem> getItem(@PathVariable Long id){
        return productClient.getItem(id);
    }

    @PostMapping("/product")
    public CommonJsonResponse addItem(@RequestBody @Valid WebuyItemForm webuyItem, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return CommonJsonResponse.fail(ProductWebMsgAndCode.PARAM_WRONG.appendMsg(message));
        }
        return productClient.addItem(webuyItem);
    }

    @DeleteMapping("/product/{id}")
    public CommonJsonResponse delItem(@PathVariable Long id){
        return productClient.delItem(id);
    }


}
