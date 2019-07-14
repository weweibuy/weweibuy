package com.weweibuy.webuy.learning.spring.csv;

import com.weweibuy.webuy.learning.spring.csv.model.CsvUser;
import com.weweibuy.webuy.learning.spring.csv.model.InvModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.*;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
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

            listReader.getHeader(false); // skip the header (can't be used with CsvListReader)
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


    @Test
    public void writeCsv() throws Exception {
        ICsvBeanWriter beanWriter = null;
        try {
            beanWriter = new CsvBeanWriter(new FileWriter("C:/Users/z/Desktop/excel/test2.csv"),
                    CsvPreference.STANDARD_PREFERENCE);

            // the header elements are used to map the bean values to each column (names must match)
            final String[] header = new String[]{"customerNo", "firstName", "lastName", "birthDate",
                    "mailingAddress", "married", "numberOfKids", "favouriteQuote", "email", "loyaltyPoints"};
            final CellProcessor[] processors = getWriterProcessors();

            // write the header
            beanWriter.writeHeader(header);

            final CsvUser john = new CsvUser("1", "John", "Dunbar",
                    new GregorianCalendar(1945, Calendar.JUNE, 13).getTime(),
                    "1600 Amphitheatre Parkway\nMountain View, CA 94043\nUnited States", null, null,
                    "\"May the Force be with you.\" - Star Wars", "jdunbar@gmail.com", 0L);
            final CsvUser bob = new CsvUser("2", "Bob", "Down",
                    new GregorianCalendar(1919, Calendar.FEBRUARY, 25).getTime(),
                    "1601 Willow Rd.\nMenlo Park, CA 94025\nUnited States", true, 0,
                    "\"Frankly, my dear, I don't give a damn.\" - Gone With The Wind", "bobdown@hotmail.com", 123456L);

            final List<CsvUser> customers = Arrays.asList(john, bob);

            for (int i = 0; i < 1000000; i++) {
                // write the beans
                for (final CsvUser customer : customers) {
                    beanWriter.write(customer, header, processors);
                }
            }
        } finally {
            if (beanWriter != null) {
                beanWriter.close();
            }
        }
    }


    @Test
    public void testVarCols() throws Exception {
        final CellProcessor[] allProcessors = new CellProcessor[]{new UniqueHashCode(), // customerNo (must be unique)
                new NotNull(), // firstName
                new NotNull(), // lastName
                new ParseDate("dd/MM/yyyy")}; // birthDate

        final CellProcessor[] noBirthDateProcessors = new CellProcessor[]{allProcessors[0], // customerNo
                allProcessors[1], // firstName
                allProcessors[2]}; // lastName

        ICsvListReader listReader = null;
        try {
            listReader = new CsvListReader(new FileReader(""), CsvPreference.STANDARD_PREFERENCE);

            listReader.getHeader(true); // skip the header (can't be used with CsvListReader)

            while ((listReader.read()) != null) {

                // use different processors depending on the number of columns
                final CellProcessor[] processors;
                if (listReader.length() == noBirthDateProcessors.length) {
                    processors = noBirthDateProcessors;
                } else {
                    processors = allProcessors;
                }

                final List<Object> customerList = listReader.executeProcessors(processors);
                System.out.println(String.format("lineNo=%s, rowNo=%s, columns=%s, customerList=%s",
                        listReader.getLineNumber(), listReader.getRowNumber(), customerList.size(), customerList));
            }

        } finally {
            if (listReader != null) {
                listReader.close();
            }
        }


    }


    private static CellProcessor[] getWriterProcessors() {

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // customerNo (must be unique)
                new NotNull(), // firstName
                new NotNull(), // lastName
                new FmtDate("dd/MM/yyyy"), // birthDate
                new NotNull(), // mailingAddress
                new Optional(new FmtBool("Y", "N")), // married
                new Optional(), // numberOfKids
                new NotNull(), // favouriteQuote
                new NotNull(), // email
                new LMinMax(0L, LMinMax.MAX_LONG) // loyaltyPoints
        };

        return processors;
    }


    public CellProcessor[] getCellProcessor() {

        final String emailRegex = "[a-z0-9/._]+@[a-z0-9/.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        final CellProcessor[] processors = new CellProcessor[]{
//                new UniqueHashCode(), // customerNo (must be unique)
                new NotNull(),
                new NotNull(), // firstName
                new NotNull(), // lastName
                new ParseDate("dd/MM/yyyy"), // birthDate
                new NotNull(), // mailingAddress
                new Optional(new ParseBool()), // married
                new Optional(new ParseInt()), // numberOfKids
                new NotNull(), // favouriteQuote
                new StrRegEx(emailRegex), // email
                new LMinMax(0L, LMinMax.MAX_LONG), // loyaltyPoints
        };
        return processors;
    }

    @Test
    public void test04() throws Exception {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(),
                new ParseDate("yyyy-MM-dd"),
                new NotNull(), // lastName
                new Optional(), // mailingAddress
                new Optional(), // married
                new Optional(), // numberOfKids
                new NotNull(new ParseInt()), // favouriteQuote
                new NotNull(new ParseInt()) // loyaltyPoints
        };


        CsvBeanReader reader = new CsvBeanReader(new FileReader("C:/Users/z/Desktop/excel/STORE_20180625.txt"), CsvPreference.TAB_PREFERENCE);

        // the header elements are used to map the values to the bean (names must match)
        final String[] header = reader.getHeader(false);



        InvModel customer;
        while ((customer = reader.read(InvModel.class, header, processors)) != null) {
            log.info("行号: {}; ROW: {}, 数据: {}", reader.getLineNumber(), reader.getRowNumber(), customer);
        }


    }


}