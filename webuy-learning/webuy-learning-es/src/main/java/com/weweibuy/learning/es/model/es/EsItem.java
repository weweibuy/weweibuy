package com.weweibuy.learning.es.model.es;

import com.weweibuy.learning.es.model.po.TbItem;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author durenhao
 * @date 2020/2/7 20:46
 **/
@Data
@Document(indexName = "dispatch_bill_info", type = "dispatch_bill_info", createIndex = false)
public class EsItem extends TbItem {
}
