package com.weweibuy.webuy.backstage.mapper;


import com.weweibuy.webuy.backstage.mapper.base.BaseMapper;
import com.weweibuy.webuy.backstage.po.TbSpecification;
import com.weweibuy.webuy.backstage.po.TbSpecificationExample;

public interface TbSpecificationMapper extends BaseMapper<TbSpecification, TbSpecificationExample> {

    int insertAndReturnPrimaryKey(TbSpecification specification);

}