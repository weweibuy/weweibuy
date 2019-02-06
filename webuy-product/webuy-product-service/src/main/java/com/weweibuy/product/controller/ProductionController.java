package com.weweibuy.product.controller;

import com.weweibuy.dto.CommonJsonResponse;
import com.weweibuy.product.common.eum.ProductWebMsgAndCode;
import com.weweibuy.product.common.model.form.WebuyItemForm;
import com.weweibuy.product.common.model.po.WebuyItem;
import com.weweibuy.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName ProductionController
 * @Description
 * @Author durenhao
 * @Date 2019/2/6 19:21
 **/
@Api("商品接口")
@Slf4j
@RestController
@RequestMapping(produces="application/json;charset=UTF-8")
public class ProductionController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    @ApiOperation("格局id查询商品信息")
    public CommonJsonResponse<WebuyItem> getItem(@PathVariable Long id){
        WebuyItem webuyItem = productService.getItemById(id);
        return CommonJsonResponse.success(webuyItem);
    }

    @PostMapping("/product")
    @ApiOperation("增加商品")
    public CommonJsonResponse addItem(@RequestBody @Valid WebuyItemForm webuyItem, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return CommonJsonResponse.fail(ProductWebMsgAndCode.PARAM_WRONG.appendMsg(message));
        }
        return productService.addItem(webuyItem);

    }

    @DeleteMapping("/product/{id}")
    @ApiOperation("增加商品")
    public CommonJsonResponse delItem(@PathVariable Long id){
        return productService.delItemById(id);
    }

}
