package com.weweibuy.webuy.learning.sharing.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/16 18:35
 **/
@Data
@AllArgsConstructor
public class PageQueryDto<T> {

    private Long total;

    private List<T> list;


}
