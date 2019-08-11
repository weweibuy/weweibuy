package com.weweibuy.webuy.learning.sharing.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author durenhao
 * @date 2019/8/10 21:32
 **/
@Data
@AllArgsConstructor
public class WarehouseInfo {

    private String warehouseCode;

    private String warehouseName;

    private short warehouseType;

}
