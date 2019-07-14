package com.weweibuy.webuy.learning.spring.mapper;

import com.weweibuy.webuy.learning.spring.model.po.CisYunjuInvTemp;
import com.weweibuy.webuy.learning.spring.model.po.CisYunjuInvTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CisYunjuInvTempMapper {
    long countByExample(CisYunjuInvTempExample example);

    int deleteByExample(CisYunjuInvTempExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CisYunjuInvTemp record);

    int insertSelective(CisYunjuInvTemp record);

    List<CisYunjuInvTemp> selectByExample(CisYunjuInvTempExample example);

    CisYunjuInvTemp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CisYunjuInvTemp record, @Param("example") CisYunjuInvTempExample example);

    int updateByExample(@Param("record") CisYunjuInvTemp record, @Param("example") CisYunjuInvTempExample example);

    int updateByPrimaryKeySelective(CisYunjuInvTemp record);

    int updateByPrimaryKey(CisYunjuInvTemp record);
}