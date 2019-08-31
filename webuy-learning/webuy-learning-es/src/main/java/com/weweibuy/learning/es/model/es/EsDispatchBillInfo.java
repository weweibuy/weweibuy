package com.weweibuy.learning.es.model.es;

import com.weweibuy.learning.es.model.po.DispatchBillInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author durenhao
 * @date 2019/8/11 9:36
 **/
@Data
@Document(indexName = "dispatch_bill_info", type = "dispatch_bill_info", createIndex = false)
public class EsDispatchBillInfo extends DispatchBillInfo {

    @Id
    private String billNo;


}
