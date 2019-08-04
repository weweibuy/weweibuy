package com.weweibuy.learning.es.service;

import com.weweibuy.learning.es.model.es.MetricData;
import com.weweibuy.learning.es.respository.MetricDataEsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2019/8/3 22:31
 **/
@Service
public class EsTestService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MetricDataEsRepository metricDataEsRepository;

    public MetricData searchById(Long id) {
        Optional<MetricData> byId = metricDataEsRepository.findById(id);
        return byId.orElseGet(null);
    }


}
