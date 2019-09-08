package com.weweibuy.webuy.learning.sharing.controller;

import com.baidu.fsg.uid.UidGenerator;
import com.weweibuy.webuy.learning.sharing.mapper.DispatchBillInfoMapper;
import com.weweibuy.webuy.learning.sharing.model.vo.DispatchPageQueryVo;
import com.weweibuy.webuy.learning.sharing.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Executor;

/**
 * @author durenhao
 * @date 2019/8/2 22:57
 **/
@RestController
@RequestMapping("/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @Autowired
    private DispatchBillInfoMapper billInfoMapper;

    @Autowired
    private UidGenerator uidGenerator;

    @Autowired
    private Executor executor;

    @PostMapping("/add")
    public String addDispatch() {
        dispatchService.addHeaderAndDetail();
        return "success";
    }

    @PostMapping("/batch-add")
    public String batchAddDispatch(Integer count) {
        if (count == null) {
            count = 10000;
        }
        Flux.range(0, count)
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(i -> dispatchService.addHeaderAndDetail())
                .sequential()
                .subscribe();
        return "success";
    }

    @PostMapping("/batch-add-all")
    public String batchAddDispatch2(Integer count) {
        if (count == null) {
            count = 10000;
        }
        Flux.range(0, count)
                .parallel(3)
                .runOn(Schedulers.fromExecutor(executor))
                .doOnNext(i -> dispatchService.addAll())
                .sequential()
                .subscribe();
        return "success";
    }


    @GetMapping("/update")
    public String updateDispatch(){
        dispatchService.updateHeaderAndDetail();
        return "success";
    }




    @GetMapping("/total")
    public Long getTotal() {
        return billInfoMapper.countByExample(null);
    }


    @PostMapping("/page")
    public Object pageQuery(@RequestBody DispatchPageQueryVo dispatchPageQueryVo) {
        return dispatchService.pageQuery(dispatchPageQueryVo);
    }


}
