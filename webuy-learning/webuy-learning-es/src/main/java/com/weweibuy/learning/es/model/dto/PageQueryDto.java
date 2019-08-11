package com.weweibuy.learning.es.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/6/16 18:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryDto<T> {

    private Long total;

    private List<T> list;


}
