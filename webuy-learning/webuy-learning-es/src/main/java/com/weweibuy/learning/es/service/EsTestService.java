package com.weweibuy.learning.es.service;

import com.weweibuy.learning.es.model.es.EsJitTimeOrderHeader;
import com.weweibuy.learning.es.model.es.MetricData;
import com.weweibuy.learning.es.respository.EsJitTimeOrderHeaderRepository;
import com.weweibuy.learning.es.respository.MetricDataEsRepository;
import com.weweibuy.webuy.common.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.stream.Stream;

/**
 * @author durenhao
 * @date 2019/8/3 22:31
 **/
@Service
@Slf4j
public class EsTestService implements InitializingBean {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MetricDataEsRepository metricDataEsRepository;

    @Autowired
    private EsJitTimeOrderHeaderRepository jitTimeOrderHeaderRepository;

    private FluxSink<EsJitTimeOrderHeader> sink;

    @Autowired
    private Executor executor;

    private static final String WAREHOUSE_NAME = "myWareHouse";
    private static final String WAREHOUSE_CODE = "myWareCode";
    private static final String VENDOR_CODE = "myVendorCode";
    private static final String VENDOR_NAME = "myVENDOR_NAME";
    private static final String CHANNEL_CODE = "jit";

    public MetricData searchById(Long id) {
        Optional<MetricData> byId = metricDataEsRepository.findById(id);
        return byId.orElseGet(null);
    }


    public void batchSave(Integer count) {
        Stream.iterate(0, n -> n + 1)
                .limit(count)
                .forEach(i -> generateAndSink());
    }


    private void generateAndSink() {
        EsJitTimeOrderHeader header = new EsJitTimeOrderHeader();
        long uid = IdWorker.getNextId();
        header.setId(uid);
        log.info("id : {}", uid);
        header.setTimeOrderNo(IdWorker.getNextStrId());
        header.setWarehouseName(WAREHOUSE_NAME);
        header.setWarehouseCode(WAREHOUSE_CODE);
        header.setVendorCode(VENDOR_CODE);
        header.setVendorName(VENDOR_NAME);
        header.setChannelCode(CHANNEL_CODE);
        header.setCreateTime(new Date());
        header.setUpdateTime(new Date());
        sink.next(header);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        EmitterProcessor<EsJitTimeOrderHeader> processor = EmitterProcessor.<EsJitTimeOrderHeader>create();

        sink = processor.sink(FluxSink.OverflowStrategy.DROP);

        processor.window(100, 100)
                .flatMap(i -> {
                    return i.collectList();
                })
                .parallel(10)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(list -> {
                    jitTimeOrderHeaderRepository.saveAll(list);
                });

    }
}
