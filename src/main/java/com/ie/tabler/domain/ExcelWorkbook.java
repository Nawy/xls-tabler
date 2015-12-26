package com.ie.tabler.domain;

import com.ie.tabler.context.ExcelContext;
import com.ie.tabler.utils.IntegerIterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 11:35 2015-12-06
 */
public class ExcelWorkbook implements ExcelContext {

    private HSSFWorkbook workbook;

    public ExcelWorkbook() {
        workbook = new HSSFWorkbook();
    }

    @Override
    public void addTable(List<?> rows) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classScheme = rows.get(0).getClass();
        ExcelTableScheme tableScheme = new ExcelTableScheme(classScheme, workbook);

        IntegerIterator rowCount = new IntegerIterator();
        IntegerIterator cellCount = new IntegerIterator();
        HSSFRow row  = tableScheme.createRow(rowCount.inc());

        this.createRowTitles(row, classScheme, tableScheme, cellCount);
        this.createRows(rows, tableScheme, rowCount, cellCount);
    }

    private void createRowTitles(HSSFRow row, Class<?> classScheme, ExcelTableScheme tableScheme, IntegerIterator cellCount) {
        for(Field field : classScheme.getDeclaredFields()) {

            HSSFCell cell = row.createCell(cellCount.inc());
            ExcelColumnScheme columnScheme = tableScheme.getColumnSchemeByName(field.getName());

            cell.setCellStyle(columnScheme.getStyle());
            cell.setCellValue(columnScheme.getTitle());
        }
    }

    private void createRows(List<?> rows, ExcelTableScheme tableScheme, IntegerIterator rowCount, IntegerIterator cellCount) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        HSSFRow row = null;
        for(Object rowObject : rows) {
            cellCount.toNull();
            row  = tableScheme.createRow(rowCount.inc());
            for(Field field : rowObject.getClass().getDeclaredFields()) {
                FieldObject fieldObject = new FieldObject(field, rowObject);
                HSSFCell cell = row.createCell(cellCount.inc());
                cell.setCellStyle(tableScheme.getSchemesRows().get(field.getName()).getStyle());
                cell.setCellValue(fieldObject.getValue().toString());
            }
        }
    }

    @Override
    public void addTable(String tableTitle, List<?> rows) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    }

    @Override
    public void writeToFile(String fileName) throws IOException {
        try(FileOutputStream out = new FileOutputStream(new File(fileName))) {
            this.writeToOutputStream(out);
            out.close();
        }
    }

    @Override
    public void writeToOutputStream(OutputStream outputStream) throws IOException {
        workbook.write(outputStream);
    }

    @Override
    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    @Override
    public byte[] getByte() {
        return workbook.getBytes();
    }
}
