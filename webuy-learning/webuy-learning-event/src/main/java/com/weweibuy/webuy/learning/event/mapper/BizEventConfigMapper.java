package com.weweibuy.webuy.learning.event.mapper;

import com.weweibuy.webuy.learning.event.model.po.BizEventConfig;
import com.weweibuy.webuy.learning.event.model.po.BizEventConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BizEventConfigMapper {
    long countByExample(BizEventConfigExample example);

    int deleteByExample(BizEventConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BizEventConfig record);

    int insertSelective(BizEventConfig record);

    BizEventConfig selectOneByExample(BizEventConfigExample example);

    List<BizEventConfig> selectByExample(BizEventConfigExample example);

    BizEventConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BizEventConfig record, @Param("example") BizEventConfigExample example);

    int updateByExample(@Param("record") BizEventConfig record, @Param("example") BizEventConfigExample example);

    int updateByPrimaryKeySelective(BizEventConfig record);

    int updateByPrimaryKey(BizEventConfig record);
}