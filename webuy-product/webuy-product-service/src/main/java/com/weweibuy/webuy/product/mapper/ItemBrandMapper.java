package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.ItemBrand;
import com.weweibuy.webuy.product.common.model.po.ItemBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemBrandMapper {
    long countByExample(ItemBrandExample example);

    int deleteByExample(ItemBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemBrand record);

    int insertSelective(ItemBrand record);

    List<ItemBrand> selectByExample(ItemBrandExample example);

    ItemBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

    int updateByExample(@Param("record") ItemBrand record, @Param("example") ItemBrandExample example);

    int updateByPrimaryKeySelective(ItemBrand record);

    int updateByPrimaryKey(ItemBrand record);
}