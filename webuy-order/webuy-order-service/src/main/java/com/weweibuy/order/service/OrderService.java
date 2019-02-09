package com.weweibuy.order.service;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.order.common.model.form.OrderAddForm;

import java.util.List;

/**
 * @InterfaceName OrderService
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 19:13
 **/
public interface OrderService {

    CommonJsonResponse addOrder(List<OrderAddForm> orderForm);

}
