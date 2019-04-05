package com.weweibuy.webuy.order.service;

import com.weweibuy.webuy.common.dto.CommonJsonResponse;
import com.weweibuy.webuy.order.common.model.form.OrderAddForm;
import com.weweibuy.webuy.order.common.model.form.OrderConfirmForm;

import java.util.List;

/**
 * @InterfaceName OrderService
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 19:13
 **/
public interface OrderService {

    CommonJsonResponse addOrder(List<OrderAddForm> orderForm);

    CommonJsonResponse confirmOrder(List<OrderConfirmForm> confirmForms);
}
