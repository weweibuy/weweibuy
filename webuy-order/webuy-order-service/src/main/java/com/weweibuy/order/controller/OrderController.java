package com.weweibuy.order.controller;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.order.common.eum.OrderWebCodeAndMsg;
import com.weweibuy.order.common.model.form.OrderAddForm;
import com.weweibuy.order.common.model.form.OrderConfirmForm;
import com.weweibuy.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName OrderController
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 18:18
 **/
@Api("订单接口")
@RestController
@RequestMapping(value = "/order",produces = "application/json;charset=UTF-8")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ApiOperation("新增订单")
    public CommonJsonResponse addOrder(@RequestBody @Valid List<OrderAddForm> orderForm, BindingResult result){
        if(result.hasErrors()){
            String message = result.getAllErrors().get(0).getDefaultMessage();
            return CommonJsonResponse.fail(OrderWebCodeAndMsg.PARAM_WRONG).appendMsg(message);
        }
        return orderService.addOrder(orderForm);
    }

    @PutMapping("/confirm")
    @ApiOperation("确认订单")
    public CommonJsonResponse confirmOrder(@RequestBody @Valid OrderConfirmForm confirmForm, BindingResult result){
        if(result.hasErrors()){
            String message = result.getAllErrors().get(0).getDefaultMessage();
            return CommonJsonResponse.fail(OrderWebCodeAndMsg.PARAM_WRONG).appendMsg(message);
        }
        return null;
    }


}
