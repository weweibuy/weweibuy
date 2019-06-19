package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetailLimit;
import com.weweibuy.webuy.learning.sharing.model.po.JitTimeOrderDetailLimitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JitTimeOrderDetailLimitMapper {
    long countByExample(JitTimeOrderDetailLimitExample example);

    int deleteByExample(JitTimeOrderDetailLimitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JitTimeOrderDetailLimit record);

    int insertSelective(JitTimeOrderDetailLimit record);

    List<JitTimeOrderDetailLimit> selectByExample(JitTimeOrderDetailLimitExample example);

    JitTimeOrderDetailLimit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JitTimeOrderDetailLimit record, @Param("example") JitTimeOrderDetailLimitExample example);

    int updateByExample(@Param("record") JitTimeOrderDetailLimit record, @Param("example") JitTimeOrderDetailLimitExample example);

    int updateByPrimaryKeySelective(JitTimeOrderDetailLimit record);

    int updateByPrimaryKey(JitTimeOrderDetailLimit record);
}