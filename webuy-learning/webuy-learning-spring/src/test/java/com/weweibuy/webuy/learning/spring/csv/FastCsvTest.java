package com.weweibuy.webuy.learning.spring.csv;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import de.siegmar.fastcsv.writer.CsvWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class FastCsvTest {


    @Test
    public void testReader() throws Exception {
        long l = System.currentTimeMillis();
        File file = new File("C:/Users/z/Desktop/excel/test/fastcsv-test3.txt");
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator('\t');
        CsvContainer csv = csvReader.read(file, StandardCharsets.UTF_8);
        csv.getRows().stream()
                .peek(row -> {
                    log.info("数据: {}", row);
                })
                .forEach(row -> {
                    log.info("第0个cell: {}", row.getField(0));
                });
        log.error("用时: {}", System.currentTimeMillis() - l);

    }


    @Test
    public void testIterativeRead() throws Exception {
        long l = System.currentTimeMillis();
        File file = new File("C:/Users/z/Desktop/excel/test/fastcsv-test3.txt");
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator('\t');
        try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow row;
            while ((row = csvParser.nextRow()) != null) {
                System.out.println("Read line: " + row);
                System.out.println("First column of line: " + row.getField(0));
            }
        }
        log.error("用时: {}", System.currentTimeMillis() - l);
    }


    @Test
    public void testWrite() throws Exception {
        File file = new File("C:/Users/z/Desktop/excel/test/fastcsv-test4.txt");
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.setFieldSeparator('\t');


        Collection<String[]> data = new ArrayList<>(150);

        for (int i = 0; i < 150000; i++) {
            if (i < 75000) {
                data.add(new String[]{"325", "2018-07-13", "仓库" + i, "BB691" + i, "6", null, "100", "0"});
            } else {
                data.add(new String[]{"325", "2018-07-13", "WH000191", null, null, "sku" + i, "100", "0"});
            }
        }

        csvWriter.write(file, Charset.forName("GBK"), data);
    }

}