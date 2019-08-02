package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfo;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchBillInfoMapper {
    long countByExample(DispatchBillInfoExample example);

    int deleteByExample(DispatchBillInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchBillInfo record);

    int insertSelective(DispatchBillInfo record);

    List<DispatchBillInfo> selectByExample(DispatchBillInfoExample example);

    DispatchBillInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchBillInfo record, @Param("example") DispatchBillInfoExample example);

    int updateByExample(@Param("record") DispatchBillInfo record, @Param("example") DispatchBillInfoExample example);

    int updateByPrimaryKeySelective(DispatchBillInfo record);

    int updateByPrimaryKey(DispatchBillInfo record);
}