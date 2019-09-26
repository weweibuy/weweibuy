package com.weweibuy.webuy.learning.event.mapper;

import com.weweibuy.webuy.learning.event.model.po.BizEvent;
import com.weweibuy.webuy.learning.event.model.po.BizEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizEventMapper {
    long countByExample(BizEventExample example);

    int deleteByExample(BizEventExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizEvent record);

    int insertSelective(BizEvent record);

    BizEvent selectOneByExample(BizEventExample example);

    List<BizEvent> selectByExample(BizEventExample example);

    BizEvent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizEvent record, @Param("example") BizEventExample example);

    int updateByExample(@Param("record") BizEvent record, @Param("example") BizEventExample example);

    int updateByPrimaryKeySelective(BizEvent record);

    int updateByPrimaryKey(BizEvent record);
}