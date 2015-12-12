package com.ie.tabler.context;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 14:04 2015-12-12
 */
public interface ExcelContext {

    byte[] getByte();

    HSSFWorkbook getWorkbook();

    void addTable(List<?> rows) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void addTable(String tableTitle, List<?> rows) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void writeToFile(String fileName)  throws IOException;

    void writeToOutputStream(OutputStream outputStream) throws IOException;
}
