package com.weweibuy.webuy.learning.spring.mapper;

import com.weweibuy.webuy.learning.spring.model.po.DispatchBillInfo;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/8/1 21:59
 **/
public interface DispatchBillInfoBatchInsertMapper {

    int batchInsert(List<DispatchBillInfo> list);

    int batchInsert2(List<DispatchBillInfo> list);

}
