package com.weweibuy.webuy.user.service.base;


import com.weweibuy.framework.common.core.model.dto.CommonPageResult;

import java.util.List;

/**
 * @InterfaceName BaseCrudService
 * @Description
 * @Author durenhao
 * @Date 2018/11/29 21:50
 **/
public interface BaseCrudService<T, V> {

    long countByExample(T t);

    int deleteByExample(V v);

    int deleteByPrimaryKey(Long id);

    int insert(T t);

    int insertSelective(V v);

    List<T> selectByExample(V v);

    T selectByPrimaryKey(Long id);

    int updateByExampleSelective(T t, V v);

    int updateByExample(T t, V v);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    CommonPageResult selectPageList(Integer page, Integer rows);

}
