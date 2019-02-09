package com.weweibuy.order.service.impl;

import com.weweibuy.common.dto.CommonJsonResponse;
import com.weweibuy.order.base.impl.BaseServiceImpl;
import com.weweibuy.order.common.model.form.OrderAddForm;
import com.weweibuy.order.common.model.po.WebuyOrder;
import com.weweibuy.order.common.model.po.WebuyOrderExample;
import com.weweibuy.order.mapper.WebuyOrderMapper;
import com.weweibuy.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonJsonResponse addOrder(List<OrderAddForm> orderForms) {
        // 先查看库存数量
        for(OrderAddForm orderAddForm : orderForms){
            Long skuId = orderAddForm.getSkuId();
        }
        WebuyOrder webuyOrder = new WebuyOrder();
        BeanUtils.copyProperties(orderForms, webuyOrder);
        // TODO 这里要防止订单重复提交
        orderMapper.insertSelectiveGetId(webuyOrder);
        return CommonJsonResponse.success(webuyOrder.getId());
    }
}
