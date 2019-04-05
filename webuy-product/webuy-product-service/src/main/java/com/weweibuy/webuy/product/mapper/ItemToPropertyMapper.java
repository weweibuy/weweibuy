package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.ItemToProperty;
import com.weweibuy.webuy.product.common.model.po.ItemToPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemToPropertyMapper {
    long countByExample(ItemToPropertyExample example);

    int deleteByExample(ItemToPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemToProperty record);

    int insertSelective(ItemToProperty record);

    List<ItemToProperty> selectByExample(ItemToPropertyExample example);

    ItemToProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemToProperty record, @Param("example") ItemToPropertyExample example);

    int updateByExample(@Param("record") ItemToProperty record, @Param("example") ItemToPropertyExample example);

    int updateByPrimaryKeySelective(ItemToProperty record);

    int updateByPrimaryKey(ItemToProperty record);
}