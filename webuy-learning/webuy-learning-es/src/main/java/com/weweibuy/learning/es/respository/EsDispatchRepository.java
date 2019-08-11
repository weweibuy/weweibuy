package com.weweibuy.learning.es.respository;

import com.weweibuy.learning.es.model.es.EsDispatchBillInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author durenhao
 * @date 2019/8/11 9:45
 **/
public interface EsDispatchRepository extends ElasticsearchRepository<EsDispatchBillInfo, String> {
}
