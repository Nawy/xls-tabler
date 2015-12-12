package com.ie.tabler.test.common;

import com.ie.tabler.context.ExcelContext;
import com.ie.tabler.factory.ExcelTabler;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 21:27 2015-12-05
 */
public class CommonTest {

    @Test
    public void carTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        List<CarsTable> cars = new ArrayList<>();
        cars.add(new CarsTable("BMW", new BigDecimal(15_000), "SOLD"));
        cars.add(new CarsTable("Ferrari", new BigDecimal(35_000), "SOLD"));
        cars.add(new CarsTable("Ford", new BigDecimal(9_000), "SOLD OUT"));
        cars.add(new CarsTable("BMW", new BigDecimal(12_000), "SOLD"));
        cars.add(new CarsTable("Renault", new BigDecimal(8_340), "SOLD OUT"));

        try {
            ExcelContext workbook = ExcelTabler.getWorkbook();
            workbook.addTable(cars);
        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
        System.out.println("Done!");

    }
}
