package com.weweibuy.webuy.learning.event.mapper;

import com.weweibuy.webuy.learning.event.model.po.BizEventLog;
import com.weweibuy.webuy.learning.event.model.po.BizEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizEventLogMapper {
    long countByExample(BizEventLogExample example);

    int deleteByExample(BizEventLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizEventLog record);

    int insertSelective(BizEventLog record);

    BizEventLog selectOneByExample(BizEventLogExample example);

    List<BizEventLog> selectByExample(BizEventLogExample example);

    BizEventLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizEventLog record, @Param("example") BizEventLogExample example);

    int updateByExample(@Param("record") BizEventLog record, @Param("example") BizEventLogExample example);

    int updateByPrimaryKeySelective(BizEventLog record);

    int updateByPrimaryKey(BizEventLog record);
}