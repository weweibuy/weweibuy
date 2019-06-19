package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetail;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JitTimeOrderDetailMapper {
    long countByExample(JitTimeOrderDetailExample example);

    int deleteByExample(JitTimeOrderDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JitTimeOrderDetail record);

    int insertSelective(JitTimeOrderDetail record);

    List<JitTimeOrderDetail> selectByExample(JitTimeOrderDetailExample example);

    JitTimeOrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JitTimeOrderDetail record, @Param("example") JitTimeOrderDetailExample example);

    int updateByExample(@Param("record") JitTimeOrderDetail record, @Param("example") JitTimeOrderDetailExample example);

    int updateByPrimaryKeySelective(JitTimeOrderDetail record);

    int updateByPrimaryKey(JitTimeOrderDetail record);
}