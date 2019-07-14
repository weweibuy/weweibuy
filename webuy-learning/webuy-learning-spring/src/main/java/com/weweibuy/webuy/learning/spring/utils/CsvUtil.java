package com.weweibuy.webuy.learning.spring.utils;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author durenhao
 * @date 2019/7/14 11:14
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvUtil {

    public static List<CsvRow> loadCsvToList(String fileName, char FileSeparator) throws IOException {
        CsvReader csvReader = new CsvReader();
        csvReader.setFieldSeparator(FileSeparator);
        CsvContainer csv = csvReader.read(new File(fileName), StandardCharsets.UTF_8);
        return csv.getRows();
    }


}
