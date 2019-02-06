package com.weweibuy.product.mapper;

import com.weweibuy.product.common.model.po.ItemProperty;
import com.weweibuy.product.common.model.po.ItemPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemPropertyMapper {
    long countByExample(ItemPropertyExample example);

    int deleteByExample(ItemPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemProperty record);

    int insertSelective(ItemProperty record);

    List<ItemProperty> selectByExample(ItemPropertyExample example);

    ItemProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemProperty record, @Param("example") ItemPropertyExample example);

    int updateByExample(@Param("record") ItemProperty record, @Param("example") ItemPropertyExample example);

    int updateByPrimaryKeySelective(ItemProperty record);

    int updateByPrimaryKey(ItemProperty record);
}