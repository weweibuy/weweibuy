package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillInfo;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveBillInfoMapper {
    long countByExample(ReceiveBillInfoExample example);

    int deleteByExample(ReceiveBillInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveBillInfo record);

    int insertSelective(ReceiveBillInfo record);

    List<ReceiveBillInfo> selectByExample(ReceiveBillInfoExample example);

    ReceiveBillInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveBillInfo record, @Param("example") ReceiveBillInfoExample example);

    int updateByExample(@Param("record") ReceiveBillInfo record, @Param("example") ReceiveBillInfoExample example);

    int updateByPrimaryKeySelective(ReceiveBillInfo record);

    int updateByPrimaryKey(ReceiveBillInfo record);
}