package com.weweibuy.webuy.learning.spring.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/7/10 21:18
 **/
@Slf4j
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();

    public void invoke(Object object, AnalysisContext context) {
        log.info("当前行: {}, 数据: {}", context.getCurrentRowNum(), object);
        datas.add(object);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
        doSomething(object);//根据自己业务做处理
    }

    private void doSomething(Object object) {

    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("解析结束销毁不用的资源");
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}