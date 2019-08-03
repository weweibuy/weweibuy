package com.weweibuy.webuy.learning.spring.mapper;

import com.weweibuy.webuy.learning.spring.model.po.DispatchBillInfo2;
import com.weweibuy.webuy.learning.spring.model.po.DispatchBillInfo2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DispatchBillInfo2Mapper {
    long countByExample(DispatchBillInfo2Example example);

    int deleteByExample(DispatchBillInfo2Example example);

    int deleteByPrimaryKey(Long id);

    int insert(DispatchBillInfo2 record);

    int insertSelective(DispatchBillInfo2 record);

    List<DispatchBillInfo2> selectByExample(DispatchBillInfo2Example example);

    DispatchBillInfo2 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DispatchBillInfo2 record, @Param("example") DispatchBillInfo2Example example);

    int updateByExample(@Param("record") DispatchBillInfo2 record, @Param("example") DispatchBillInfo2Example example);

    int updateByPrimaryKeySelective(DispatchBillInfo2 record);

    int updateByPrimaryKey(DispatchBillInfo2 record);
}