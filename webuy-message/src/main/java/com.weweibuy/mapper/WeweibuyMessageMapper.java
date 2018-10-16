package com.weweibuy.mapper;

import com.weweibuy.po.WeweibuyMessage;
import com.weweibuy.po.WeweibuyMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeweibuyMessageMapper {
    int countByExample(WeweibuyMessageExample example);

    int deleteByExample(WeweibuyMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WeweibuyMessage record);

    int insertSelective(WeweibuyMessage record);

    List<WeweibuyMessage> selectByExample(WeweibuyMessageExample example);

    WeweibuyMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WeweibuyMessage record, @Param("example") WeweibuyMessageExample example);

    int updateByExample(@Param("record") WeweibuyMessage record, @Param("example") WeweibuyMessageExample example);

    int updateByPrimaryKeySelective(WeweibuyMessage record);

    int updateByPrimaryKey(WeweibuyMessage record);
}