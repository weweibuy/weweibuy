package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.DispatchBillDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DispatchBillDetailMapper {
    long countByExample(DispatchBillDetailExample example);

    int deleteByExample(DispatchBillDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchBillDetail record);

    int insertSelective(DispatchBillDetail record);

    List<DispatchBillDetail> selectByExample(DispatchBillDetailExample example);

    DispatchBillDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchBillDetail record, @Param("example") DispatchBillDetailExample example);

    int updateByExample(@Param("record") DispatchBillDetail record, @Param("example") DispatchBillDetailExample example);

    int updateByPrimaryKeySelective(DispatchBillDetail record);

    int updateByPrimaryKey(DispatchBillDetail record);
}