package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillSettlementInfo;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillSettlementInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveBillSettlementInfoMapper {
    long countByExample(ReceiveBillSettlementInfoExample example);

    int deleteByExample(ReceiveBillSettlementInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveBillSettlementInfo record);

    int insertSelective(ReceiveBillSettlementInfo record);

    List<ReceiveBillSettlementInfo> selectByExample(ReceiveBillSettlementInfoExample example);

    ReceiveBillSettlementInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveBillSettlementInfo record, @Param("example") ReceiveBillSettlementInfoExample example);

    int updateByExample(@Param("record") ReceiveBillSettlementInfo record, @Param("example") ReceiveBillSettlementInfoExample example);

    int updateByPrimaryKeySelective(ReceiveBillSettlementInfo record);

    int updateByPrimaryKey(ReceiveBillSettlementInfo record);
}