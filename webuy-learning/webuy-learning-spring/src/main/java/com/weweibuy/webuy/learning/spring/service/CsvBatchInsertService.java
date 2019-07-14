package com.weweibuy.webuy.learning.spring.service;

import com.weweibuy.webuy.learning.spring.mapper.CisYunjuInvTempMapper;
import com.weweibuy.webuy.learning.spring.mapper.CsvBatchInsertMapper;
import com.weweibuy.webuy.learning.spring.model.po.CisYunjuInvTemp;
import com.weweibuy.webuy.learning.spring.utils.CsvUtil;
import de.siegmar.fastcsv.reader.CsvRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author durenhao
 * @date 2019/7/13 20:46
 **/
@Slf4j
@Service
public class CsvBatchInsertService {

    private static final String FILENAME = "C:/Users/z/Desktop/excel/test/fastcsv-test3.txt";
    private static final char FIELD_SEPARATOR = '\t';

    @Autowired
    private Executor executor;

    @Autowired
    private CsvBatchInsertMapper csvBatchInsertMapper;

    @Autowired
    private CisYunjuInvTempMapper yunjuInvTempMapper;

    public void batchInsert() throws Exception {


        long l = System.currentTimeMillis();
        AtomicInteger atomicInteger = new AtomicInteger();
        List<CsvRow> csvRows = CsvUtil.loadCsvToList(FILENAME, FIELD_SEPARATOR);
        Flux.fromStream(csvRows.stream())
                .doOnNext(row -> {
                    String field = row.getField(6);
                    atomicInteger.addAndGet(Integer.valueOf(field));
                })
                .window(500, 500)
                .flatMap(i -> {
                    return i.collectList();
                })
                .parallel(10)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(csvBatchInsertMapper::batchInsert)
                .doOnError(e -> {
                    log.error("【消费数据异常】 >>>  ", e);
                })
                .sequential()
                .doOnComplete(() -> {
                    log.info("总计数量: {}; 耗时: {}", atomicInteger.get(), System.currentTimeMillis() - l);
                })
                .subscribe();
    }


    public void insert(){
        CisYunjuInvTemp cisYunjuInvTemp = new CisYunjuInvTemp();
        cisYunjuInvTemp.setWarehouseCode("WH000191");
        cisYunjuInvTemp.setProductNo("sku999");
        cisYunjuInvTemp.setQty(15);
        yunjuInvTempMapper.insertSelective(cisYunjuInvTemp);
    }

}
