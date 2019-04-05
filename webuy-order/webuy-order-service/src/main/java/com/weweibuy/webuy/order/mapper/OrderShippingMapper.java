package com.weweibuy.webuy.order.mapper;

import com.weweibuy.webuy.order.common.model.po.OrderShipping;
import com.weweibuy.webuy.order.common.model.po.OrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderShippingMapper {
    long countByExample(OrderShippingExample example);

    int deleteByExample(OrderShippingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderShipping record);

    int insertSelective(OrderShipping record);

    List<OrderShipping> selectByExample(OrderShippingExample example);

    OrderShipping selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    int updateByExample(@Param("record") OrderShipping record, @Param("example") OrderShippingExample example);

    int updateByPrimaryKeySelective(OrderShipping record);

    int updateByPrimaryKey(OrderShipping record);
}