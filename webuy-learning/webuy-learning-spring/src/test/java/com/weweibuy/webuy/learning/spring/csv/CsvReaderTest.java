package com.weweibuy.webuy.learning.spring.csv;

import com.weweibuy.webuy.learning.spring.csv.model.CsvUser;
import org.junit.Test;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.List;

public class CsvReaderTest {


    @Test
    public void test() throws Exception {
        ICsvBeanReader beanReader = null;
        try {
            beanReader = new CsvBeanReader(new FileReader("C:/Users/z/Desktop/excel/test.csv"), CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the values to the bean (names must match)
            final String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getCellProcessor();

            CsvUser customer;
            while ((customer = beanReader.read(CsvUser.class, header, processors)) != null) {
                System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
                        beanReader.getRowNumber(), customer));
            }

        } finally {
            if (beanReader != null) {
                beanReader.close();
            }
        }
    }


    @Test
    public void testCsvList() throws Exception {
        ICsvListReader listReader = null;
        try {
            listReader = new CsvListReader(new FileReader("C:/Users/z/Desktop/excel/test.csv"), CsvPreference.STANDARD_PREFERENCE);

            listReader.getHeader(true); // skip the header (can't be used with CsvListReader)
            final CellProcessor[] processors = getCellProcessor();

            List<Object> customerList;
            while ((customerList = listReader.read(processors)) != null) {
                System.out.println(String.format("lineNo=%s, rowNo=%s, customerList=%s", listReader.getLineNumber(),
                        listReader.getRowNumber(), customerList));
            }

        } finally {
            if (listReader != null) {
                listReader.close();
            }
        }
    }



    public CellProcessor[] getCellProcessor() {

        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        final CellProcessor[] processors = new CellProcessor[]{
                new UniqueHashCode(), // customerNo (must be unique)
                new NotNull(), // firstName
                new NotNull(), // lastName
                new ParseDate("dd/MM/yyyy"), // birthDate
                new NotNull(), // mailingAddress
                new Optional(new ParseBool()), // married
                new Optional(new ParseInt()), // numberOfKids
                new NotNull(), // favouriteQuote
                new StrRegEx(emailRegex), // email
                new LMinMax(0L, LMinMax.MAX_LONG) // loyaltyPoints
        };
        return processors;
    }

}