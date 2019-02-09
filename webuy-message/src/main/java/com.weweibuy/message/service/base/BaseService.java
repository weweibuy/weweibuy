package com.weweibuy.message.service.base;


import com.weweibuy.common.dto.CommonPageResult;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, V> {

    int countByExample(V v);

    int deleteByExample(V v);

    int deleteByPrimaryKey(Serializable id);

    int insert(T t);

    int insertSelective(T t);

    List<T> selectByExample(V v);

    T selectByPrimaryKey(Serializable id);

    int updateByExampleSelective(T t, V v);

    int updateByExample(T t, V v);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    CommonPageResult selectPageList(Integer page, Integer rows);


}
