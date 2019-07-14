package com.weweibuy.webuy.learning.spring.controller;

import com.weweibuy.webuy.learning.spring.service.CsvBatchInsertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试  csv 批量插入
 *
 * @author durenhao
 * @date 2019/7/13 20:39
 **/
@Slf4j
@RestController
@RequestMapping("/csv")
public class CsvBatchInsertController {

    @Autowired
    private CsvBatchInsertService csvBatchInsertService;

    @GetMapping("/batch-insert")
    public String batchInsert() throws Exception {
        long l = System.currentTimeMillis();
        csvBatchInsertService.batchInsert();
        log.error("用时: {}", System.currentTimeMillis() - l);
        return "success";
    }


    @GetMapping("/insert")
    public String insert() throws Exception {
        long l = System.currentTimeMillis();
        csvBatchInsertService.insert();
        log.info("用时: {}", System.currentTimeMillis() - l);
        return "success";
    }

}
