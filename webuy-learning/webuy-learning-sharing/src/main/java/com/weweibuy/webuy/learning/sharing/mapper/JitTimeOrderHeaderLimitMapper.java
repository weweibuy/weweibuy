package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeaderLimit;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeaderLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JitTimeOrderHeaderLimitMapper {
    long countByExample(JitTimeOrderHeaderLimitExample example);

    int deleteByExample(JitTimeOrderHeaderLimitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JitTimeOrderHeaderLimit record);

    int insertSelective(JitTimeOrderHeaderLimit record);

    List<JitTimeOrderHeaderLimit> selectByExample(JitTimeOrderHeaderLimitExample example);

    JitTimeOrderHeaderLimit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JitTimeOrderHeaderLimit record, @Param("example") JitTimeOrderHeaderLimitExample example);

    int updateByExample(@Param("record") JitTimeOrderHeaderLimit record, @Param("example") JitTimeOrderHeaderLimitExample example);

    int updateByPrimaryKeySelective(JitTimeOrderHeaderLimit record);

    int updateByPrimaryKey(JitTimeOrderHeaderLimit record);
}