package com.weweibuy.webuy.order.mapper;

import com.weweibuy.webuy.order.common.model.po.ShippingMethod;
import com.weweibuy.webuy.order.common.model.po.ShippingMethodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingMethodMapper {
    long countByExample(ShippingMethodExample example);

    int deleteByExample(ShippingMethodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShippingMethod record);

    int insertSelective(ShippingMethod record);

    List<ShippingMethod> selectByExample(ShippingMethodExample example);

    ShippingMethod selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShippingMethod record, @Param("example") ShippingMethodExample example);

    int updateByExample(@Param("record") ShippingMethod record, @Param("example") ShippingMethodExample example);

    int updateByPrimaryKeySelective(ShippingMethod record);

    int updateByPrimaryKey(ShippingMethod record);
}