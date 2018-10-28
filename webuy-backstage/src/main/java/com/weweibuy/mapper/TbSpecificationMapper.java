package com.weweibuy.mapper;


import com.weweibuy.mapper.base.BaseMapper;
import com.weweibuy.po.TbSpecification;
import com.weweibuy.po.TbSpecificationExample;

public interface TbSpecificationMapper extends BaseMapper<TbSpecification, TbSpecificationExample> {

    int insertAndReturnPrimaryKey(TbSpecification specification);

}