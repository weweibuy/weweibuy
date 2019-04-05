package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.ItemCategory;
import com.weweibuy.webuy.product.common.model.po.ItemCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemCategoryMapper {
    long countByExample(ItemCategoryExample example);

    int deleteByExample(ItemCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

    List<ItemCategory> selectByExample(ItemCategoryExample example);

    ItemCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemCategory record, @Param("example") ItemCategoryExample example);

    int updateByExample(@Param("record") ItemCategory record, @Param("example") ItemCategoryExample example);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);
}