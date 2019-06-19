package com.weweibuy.webuy.learning.spring.mapper;

import com.weweibuy.webuy.learning.spring.model.po.TestDog;
import com.weweibuy.webuy.learning.spring.model.po.TestDogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestDogMapper {
    long countByExample(TestDogExample example);

    int deleteByExample(TestDogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestDog record);

    int insertSelective(TestDog record);

    List<TestDog> selectByExample(TestDogExample example);

    TestDog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TestDog record, @Param("example") TestDogExample example);

    int updateByExample(@Param("record") TestDog record, @Param("example") TestDogExample example);

    int updateByPrimaryKeySelective(TestDog record);

    int updateByPrimaryKey(TestDog record);
}