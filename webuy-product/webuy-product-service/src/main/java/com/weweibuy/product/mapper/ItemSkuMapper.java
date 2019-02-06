package com.weweibuy.product.mapper;

import com.weweibuy.product.common.model.po.ItemSku;
import com.weweibuy.product.common.model.po.ItemSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemSkuMapper {
    long countByExample(ItemSkuExample example);

    int deleteByExample(ItemSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSku record);

    int insertSelective(ItemSku record);

    List<ItemSku> selectByExample(ItemSkuExample example);

    ItemSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSku record, @Param("example") ItemSkuExample example);

    int updateByExample(@Param("record") ItemSku record, @Param("example") ItemSkuExample example);

    int updateByPrimaryKeySelective(ItemSku record);

    int updateByPrimaryKey(ItemSku record);
}