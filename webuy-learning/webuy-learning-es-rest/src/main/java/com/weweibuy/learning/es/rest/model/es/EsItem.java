package com.weweibuy.learning.es.rest.model.es;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weweibuy.learning.es.rest.model.po.TbItem;
import lombok.Data;

/**
 * @author durenhao
 * @date 2020/2/9 11:42
 **/
@Data
public class EsItem extends TbItem {

    @JsonProperty("_id")
    private Long id;


}
