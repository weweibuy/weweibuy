package com.weiwei.mapper;


import com.weiwei.mapper.base.BaseMapper;
import com.weiwei.po.TbSpecification;
import com.weiwei.po.TbSpecificationExample;

public interface TbSpecificationMapper extends BaseMapper<TbSpecification, TbSpecificationExample> {

    int insertAndReturnPrimaryKey(TbSpecification specification);

}