package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeader;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderHeaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JitTimeOrderHeaderMapper {
    long countByExample(JitTimeOrderHeaderExample example);

    int deleteByExample(JitTimeOrderHeaderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JitTimeOrderHeader record);

    int insertSelective(JitTimeOrderHeader record);

    List<JitTimeOrderHeader> selectByExample(JitTimeOrderHeaderExample example);

    JitTimeOrderHeader selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JitTimeOrderHeader record, @Param("example") JitTimeOrderHeaderExample example);

    int updateByExample(@Param("record") JitTimeOrderHeader record, @Param("example") JitTimeOrderHeaderExample example);

    int updateByPrimaryKeySelective(JitTimeOrderHeader record);

    int updateByPrimaryKey(JitTimeOrderHeader record);
}