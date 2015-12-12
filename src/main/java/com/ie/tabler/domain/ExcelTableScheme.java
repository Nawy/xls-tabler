package com.ie.tabler.domain;

import com.ie.tabler.annotation.*;
import com.ie.tabler.exception.InvalidTableClass;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 01:04 2015-12-12
 */
public class ExcelTableScheme {

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;
    private String title;
    private Map<String, ExcelScheme> schemesRows;
    private Map<String, ExcelColumnScheme> schemeColumns;

    public ExcelTableScheme(Class<?> schemeClass, HSSFWorkbook workbook) throws InvalidTableClass {

        schemeColumns = new HashMap<>();
        schemesRows = new HashMap<>();

        this.workbook = workbook;

        XlsTable tableAnnotation = schemeClass != null ?
                schemeClass.getAnnotation(XlsTable.class) : null;

        if(tableAnnotation == null) {
            throw new InvalidTableClass("Invalid class for XLS scheme");
        }

        this.title = tableAnnotation.value();

        Field[] fields = schemeClass.getDeclaredFields();
        for(Field field : fields) {
            XlsColumn columnAnnotation = field.getAnnotation(XlsColumn.class);
            XlsFont fontAnnotation = field.getAnnotation(XlsFont.class);
            XlsBorder borderAnnotation = field.getAnnotation(XlsBorder.class);
            XlsAlign alignAnnotation = field.getAnnotation(XlsAlign.class);

            ExcelColumnScheme columnScheme = new ExcelColumnScheme(columnAnnotation, workbook);
            ExcelScheme rowScheme = new ExcelScheme(fontAnnotation, borderAnnotation, alignAnnotation, workbook);

            schemeColumns.put(field.getName(), columnScheme);
            schemesRows.put(field.getName(), rowScheme);
        }

        sheet = this.workbook.createSheet(this.title);
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    public HSSFSheet getSheet() {
        return sheet;
    }

    public void setSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, ExcelScheme> getSchemesRows() {
        return schemesRows;
    }

    public void setSchemesRows(Map<String, ExcelScheme> schemesRows) {
        this.schemesRows = schemesRows;
    }

    public Map<String, ExcelColumnScheme> getSchemeColumns() {
        return schemeColumns;
    }

    public void setSchemeColumns(Map<String, ExcelColumnScheme> schemeColumns) {
        this.schemeColumns = schemeColumns;
    }
}
