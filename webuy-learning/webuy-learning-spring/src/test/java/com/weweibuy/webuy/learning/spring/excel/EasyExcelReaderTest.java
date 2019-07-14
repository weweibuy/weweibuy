package com.weweibuy.webuy.learning.spring.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.weweibuy.webuy.learning.spring.excel.model.UserRowModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class EasyExcelReaderTest {


    @Test
    public void test01() throws Exception {
        InputStream inputStream = new FileInputStream("C:/Users/z/Desktop/excel/新建 Microsoft Excel 工作表.xlsx");
        try {
            // 解析每行结果在listener中处理
            ExcelListener listener = new ExcelListener();
            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
            excelReader.read(new Sheet(1, 1, UserRowModel.class));
            List<Object> datas = listener.getDatas();
            log.info("最终读取数据: {}", datas);
            Thread.sleep(2000);
        } catch (Exception e) {

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void saxReadListStringV2007() throws IOException {

        InputStream inputStream = new FileInputStream("C:\\Users\\z\\Desktop\\excel\\新建 Microsoft Excel 工作表.xlsx");
        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();
        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
        excelReader.read(new Sheet(1, 1, UserRowModel.class));
        List datas = listener.getDatas();

        OutputStream out = new FileOutputStream("C:/Users/z/Desktop/excel/test01.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, false);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        List list = new ArrayList<>();

        writer.write(createTestListObject(), sheet1);
        writer.finish();
        inputStream.close();
        out.close();
    }


    public static List createTestListObject() {
        List<List<Object>> object = new ArrayList<List<Object>>();
        for (int i = 0; i < 1000; i++) {
            List<Object> da = new ArrayList<Object>();
            da.add("字符串"+i);
            da.add(Long.valueOf(187837834l+i));
            da.add(Integer.valueOf(2233+i));
            da.add(Double.valueOf(2233.00+i));
            da.add(Float.valueOf(2233.0f+i));
            da.add(new Date());
            da.add(new BigDecimal("3434343433554545"+i));
            da.add(Short.valueOf((short)i));
            object.add(da);
        }
        return object;
    }

}

