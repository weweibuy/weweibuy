package com.weweibuy.webuy.learning.sharing.mapper;

import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillDetail;
import com.weweibuy.webuy.learning.sharing.model.po.ReceiveBillDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceiveBillDetailMapper {
    long countByExample(ReceiveBillDetailExample example);

    int deleteByExample(ReceiveBillDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ReceiveBillDetail record);

    int insertSelective(ReceiveBillDetail record);

    List<ReceiveBillDetail> selectByExample(ReceiveBillDetailExample example);

    ReceiveBillDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ReceiveBillDetail record, @Param("example") ReceiveBillDetailExample example);

    int updateByExample(@Param("record") ReceiveBillDetail record, @Param("example") ReceiveBillDetailExample example);

    int updateByPrimaryKeySelective(ReceiveBillDetail record);

    int updateByPrimaryKey(ReceiveBillDetail record);
}