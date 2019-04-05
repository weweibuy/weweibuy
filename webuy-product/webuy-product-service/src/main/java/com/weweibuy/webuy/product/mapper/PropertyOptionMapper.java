package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.PropertyOption;
import com.weweibuy.webuy.product.common.model.po.PropertyOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyOptionMapper {
    long countByExample(PropertyOptionExample example);

    int deleteByExample(PropertyOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyOption record);

    int insertSelective(PropertyOption record);

    List<PropertyOption> selectByExample(PropertyOptionExample example);

    PropertyOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyOption record, @Param("example") PropertyOptionExample example);

    int updateByExample(@Param("record") PropertyOption record, @Param("example") PropertyOptionExample example);

    int updateByPrimaryKeySelective(PropertyOption record);

    int updateByPrimaryKey(PropertyOption record);
}