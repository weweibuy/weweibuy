package com.weweibuy.webuy.learning.drools.controller;

import lombok.RequiredArgsConstructor;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author durenhao
 * @date 2020/11/7 10:07
 **/
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DecisionTableController {

    private final KieBase kieBase;

    @GetMapping("/table")
    public String table() throws FileNotFoundException {
        //指定决策表xls文件的磁盘路径
//        String realPath = "F:/Down load/download/drools教程/讲义及资料/第四天/资料/testRule.xls";
        String realPath = "F:/Down load/download/drools教程/讲义及资料/第四天/资料/insuranceInfoCheck.xls";
        File file = new File(realPath);
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
        return drl;
    }


}
