package com.weweibuy.webuy.product.mapper;

import com.weweibuy.webuy.product.common.model.po.SpecificationOption;
import com.weweibuy.webuy.product.common.model.po.SpecificationOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationOptionMapper {
    long countByExample(SpecificationOptionExample example);

    int deleteByExample(SpecificationOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    List<SpecificationOption> selectByExample(SpecificationOptionExample example);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionExample example);

    int updateByExample(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionExample example);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);
}