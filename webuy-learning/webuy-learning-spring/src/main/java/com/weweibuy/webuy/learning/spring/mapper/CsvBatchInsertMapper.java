package com.weweibuy.webuy.learning.spring.mapper;

import de.siegmar.fastcsv.reader.CsvRow;

import java.util.List;

/**
 * @author durenhao
 * @date 2019/7/13 20:47
 **/
public interface CsvBatchInsertMapper {

    int batchInsert(List<CsvRow> csvRowList);

}
