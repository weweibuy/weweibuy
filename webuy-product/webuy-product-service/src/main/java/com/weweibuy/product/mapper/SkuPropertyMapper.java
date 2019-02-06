package com.weweibuy.product.mapper;

import com.weweibuy.product.common.model.po.SkuProperty;
import com.weweibuy.product.common.model.po.SkuPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuPropertyMapper {
    long countByExample(SkuPropertyExample example);

    int deleteByExample(SkuPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuProperty record);

    int insertSelective(SkuProperty record);

    List<SkuProperty> selectByExample(SkuPropertyExample example);

    SkuProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuProperty record, @Param("example") SkuPropertyExample example);

    int updateByExample(@Param("record") SkuProperty record, @Param("example") SkuPropertyExample example);

    int updateByPrimaryKeySelective(SkuProperty record);

    int updateByPrimaryKey(SkuProperty record);
}