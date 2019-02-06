package com.weweibuy.product.mapper;

import com.weweibuy.product.common.model.po.ItemSpecification;
import com.weweibuy.product.common.model.po.ItemSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemSpecificationMapper {
    long countByExample(ItemSpecificationExample example);

    int deleteByExample(ItemSpecificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSpecification record);

    int insertSelective(ItemSpecification record);

    List<ItemSpecification> selectByExample(ItemSpecificationExample example);

    ItemSpecification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSpecification record, @Param("example") ItemSpecificationExample example);

    int updateByExample(@Param("record") ItemSpecification record, @Param("example") ItemSpecificationExample example);

    int updateByPrimaryKeySelective(ItemSpecification record);

    int updateByPrimaryKey(ItemSpecification record);
}