package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillSettlementInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillSettlementInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchBillSettlementInfoMapper {
    long countByExample(DispatchBillSettlementInfoExample example);

    int deleteByExample(DispatchBillSettlementInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchBillSettlementInfo record);

    int insertSelective(DispatchBillSettlementInfo record);

    List<DispatchBillSettlementInfo> selectByExample(DispatchBillSettlementInfoExample example);

    DispatchBillSettlementInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchBillSettlementInfo record, @Param("example") DispatchBillSettlementInfoExample example);

    int updateByExample(@Param("record") DispatchBillSettlementInfo record, @Param("example") DispatchBillSettlementInfoExample example);

    int updateByPrimaryKeySelective(DispatchBillSettlementInfo record);

    int updateByPrimaryKey(DispatchBillSettlementInfo record);
}