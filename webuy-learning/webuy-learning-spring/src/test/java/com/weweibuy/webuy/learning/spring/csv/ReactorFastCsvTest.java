package com.weweibuy.webuy.learning.spring.csv;

import com.weweibuy.webuy.learning.spring.reactor.MyEventListener;
import com.weweibuy.webuy.learning.spring.reactor.MyEventProcessor;
import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.UnicastProcessor;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author durenhao
 * @date 2019/7/13 10:54
 **/
@Slf4j
public class ReactorFastCsvTest {

    private static final String FILENAME = "C:/Users/z/Desktop/excel/test/fastcsv-test3.txt";
    private static final char FIELD_SEPARATOR = '\t';

    private Integer count = 0;

    private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    private ThreadPoolTaskExecutor executor2 = new ThreadPoolTaskExecutor();


    {
        executor.setMaxPoolSize(5);
        executor.setCorePoolSize(3);
        executor.setThreadNamePrefix("reactor-subscribe-csv-test-");
        executor.initialize();

        executor2.setMaxPoolSize(5);
        executor2.setCorePoolSize(3);
        executor2.setThreadNamePrefix("reactor-publish-csv-test-");
        executor2.initialize();
    }


    @Test
    public void testClod() throws Exception {
        File file = new File(FILENAME);
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator(FIELD_SEPARATOR);
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        MyEventProcessor myEventProcessor = new MyEventProcessor();
        Flux<CsvRow> rowFlux = Flux.<CsvRow>create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<CsvRow>() {

                        public void onDataChunk(CsvRow chunk) {
                            sink.next(chunk);
                        }

                        public void processComplete() {
                            log.error("完成了");
                            sink.complete();
                        }
                    });
        }, FluxSink.OverflowStrategy.BUFFER);

        rowFlux.window(100, 100)
                .concatMap(flRow -> {
                    return flRow;
                })
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                // 这里如果传入 BaseSubscriber 将会串行
                .subscribe(value -> {
                    log.info("【消费数据】 >>> {} ", value);
                });

        csv.getRows().forEach(row -> {
            log.error("【发射数据】 >>>  {}", row);
            myEventProcessor.getListener().onDataChunk(row);
        });
    }


    @Test
    public void testClod2() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        File file = new File(FILENAME);
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator(FIELD_SEPARATOR);
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        Flux.fromStream(csv.getRows().stream())
                .window(100, 100)
                .concatMap(flRow -> {
                    return flRow;
                })
                .parallel(5)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnComplete(() -> {
                    log.info("数据处理完毕, 总数: {}", count);
                    countDownLatch.countDown();
                })
                .subscribe(row -> {
                    setCount();
                    log.info("【消费数据】 >>> {} ", row);
                });
        countDownLatch.await();
        Thread.sleep(1000);
    }

    private void setCount() {
        count++;
    }

    @Test
    public void testHot() throws Exception {
        long l = System.currentTimeMillis();
        UnicastProcessor<CsvRow> hotSource = UnicastProcessor.create();
        File file = new File(FILENAME);
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator(FIELD_SEPARATOR);
        AtomicInteger atomicInteger = new AtomicInteger();
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        hotSource
                .doOnNext(row -> {
                    setCount();
                    String field = row.getField(6);
                    atomicInteger.addAndGet(Integer.valueOf(field));
                })
                .window(100, 100)
                .flatMap(i -> {
                    return i.collectList();
                })
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(row -> {
                    if (count == 10000) {
                        log.info("【消费数据】 >>> {} ", row.get(102));
                    } else {
                        log.info("【消费数据】 >>> {} ", row);
                    }
                })
                .doOnError(row -> {
                    log.error("【消费数据异常】 >>> 总计数量 {} ", atomicInteger.get());
                })
                .subscribe();

        csv.getRows().forEach(row -> {
            log.error("【发射数据】 >>>  {}", row);
            hotSource.onNext(row);
        });
        log.info("用时: {}; 行数: {};总计数量: {}", System.currentTimeMillis() - l, count, atomicInteger.get());

    }


}
