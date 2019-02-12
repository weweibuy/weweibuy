package com.weweibuy.order.service.impl;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.inventory.client.InventoryClient;
import com.weweibuy.order.base.impl.BaseServiceImpl;
import com.weweibuy.order.common.model.form.OrderAddForm;
import com.weweibuy.order.common.model.form.OrderConfirmForm;
import com.weweibuy.order.common.model.po.WebuyOrder;
import com.weweibuy.order.common.model.po.WebuyOrderExample;
import com.weweibuy.order.mapper.WebuyOrderMapper;
import com.weweibuy.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2019/2/8 19:14
 **/
@Service
public class OrderServiceImpl extends BaseServiceImpl<WebuyOrder, WebuyOrderExample> implements OrderService {

    @Autowired
    private WebuyOrderMapper orderMapper;

    @Autowired
    @Lazy
    private InventoryClient inventoryClient;

    @Override
    public CommonJsonResponse addOrder(List<OrderAddForm> orderForms) {
        ArrayList<WebuyOrder> webuyOrders = convertData(orderForms);
        savaOrder(webuyOrders);
        return CommonJsonResponse.success(webuyOrders);
    }

    @Override
    public CommonJsonResponse confirmOrder(List<OrderConfirmForm> confirmForms) {
        // TODO 检查并锁定库存信息
        // 向Redis推送确认但未支付订单
        // 保存订单信息到数据库
        return null;
    }


    private ArrayList<WebuyOrder> convertData(List<OrderAddForm> orderForms){
        WebuyOrder webuyOrder = null;
        ArrayList<WebuyOrder> webuyOrders = new ArrayList<>();
        for(OrderAddForm orderAddForm : orderForms){
            webuyOrder = new WebuyOrder();
        BeanUtils.copyProperties(orderAddForm, webuyOrder);
        webuyOrders.add(webuyOrder);
    }
        return webuyOrders;
    }

    @Transactional(rollbackFor = Exception.class)
    private void savaOrder(ArrayList<WebuyOrder> webuyOrders){
        for(WebuyOrder webuyOrder : webuyOrders){
            orderMapper.insertSelectiveGetId(webuyOrder);
        }
    }

}
