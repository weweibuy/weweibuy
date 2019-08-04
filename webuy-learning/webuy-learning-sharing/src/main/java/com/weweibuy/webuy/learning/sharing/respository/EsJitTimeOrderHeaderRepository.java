package com.weweibuy.webuy.learning.sharing.respository;

import com.weweibuy.webuy.learning.sharing.model.es.EsJitTimeOrderHeader;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author durenhao
 * @date 2019/8/4 10:15
 **/
public interface EsJitTimeOrderHeaderRepository extends ElasticsearchRepository<EsJitTimeOrderHeader, Long> {
}
