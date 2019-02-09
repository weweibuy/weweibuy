package com.weweibuy.order.mapper;

import com.weweibuy.order.common.model.po.WebuyOrder;
import com.weweibuy.order.common.model.po.WebuyOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebuyOrderMapper {
    long countByExample(WebuyOrderExample example);

    int deleteByExample(WebuyOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebuyOrder record);

    int insertSelective(WebuyOrder record);

    int insertSelectiveGetId(WebuyOrder record);

    List<WebuyOrder> selectByExample(WebuyOrderExample example);

    WebuyOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebuyOrder record, @Param("example") WebuyOrderExample example);

    int updateByExample(@Param("record") WebuyOrder record, @Param("example") WebuyOrderExample example);

    int updateByPrimaryKeySelective(WebuyOrder record);

    int updateByPrimaryKey(WebuyOrder record);
}