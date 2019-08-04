package com.weweibuy.learning.es.respository;

import com.weweibuy.learning.es.model.es.MetricData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author durenhao
 * @date 2019/8/4 10:15
 **/
public interface MetricDataEsRepository extends ElasticsearchRepository<MetricData, Long> {
}
