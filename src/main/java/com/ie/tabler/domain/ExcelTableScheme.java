package com.ie.tabler.domain;

import com.ie.tabler.annotation.*;
import com.ie.tabler.exception.InvalidTableClass;
import org.apache.poi.hssf.usermodel.HSSFRow;
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
    private ExcelTitleScheme titleScheme;
    private Map<String, ExcelScheme> schemesRows;
    private Map<String, ExcelTitleScheme> schemeColumns;

    public ExcelTableScheme(Class<?> schemeClass, HSSFWorkbook workbook) throws InvalidTableClass {

        schemeColumns = new HashMap<>();
        schemesRows = new HashMap<>();

        this.workbook = workbook;

        XlsTable tableAnnotation = schemeClass != null ?
                schemeClass.getAnnotation(XlsTable.class) : null;

        if(tableAnnotation == null) {
            throw new InvalidTableClass("Invalid class for XLS scheme");
        }

        XlsTitle tableTitleAnnotation = schemeClass.getAnnotation(XlsTitle.class);
        if(tableTitleAnnotation != null) {
            this.titleScheme = new ExcelTitleScheme(tableTitleAnnotation, workbook);
        }

        Field[] fields = schemeClass.getDeclaredFields();
        for(Field field : fields) {
            XlsTitle columnAnnotation = field.getAnnotation(XlsTitle.class);
            XlsFont fontAnnotation = field.getAnnotation(XlsFont.class);
            XlsBorder borderAnnotation = field.getAnnotation(XlsBorder.class);
            XlsAlign alignAnnotation = field.getAnnotation(XlsAlign.class);

            ExcelTitleScheme columnScheme = new ExcelTitleScheme(columnAnnotation, workbook);
            ExcelScheme rowScheme = new ExcelScheme.Builder()
                    .workbook(workbook)
                    .border(borderAnnotation)
                    .font(fontAnnotation)
                    .align(alignAnnotation)
                    .build();

            schemeColumns.put(field.getName(), columnScheme);
            schemesRows.put(field.getName(), rowScheme);
        }

        sheet = this.workbook.createSheet(this.titleScheme.getTitle());
    }
    public ExcelTitleScheme getColumnSchemeByName(String name) {
        return schemeColumns.get(name);
    }

    public HSSFRow createRow(int rowIndex) {
        return this.sheet.createRow(rowIndex);
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

    public ExcelTitleScheme getTitleScheme() {
        return titleScheme;
    }

    public void setTitleScheme(ExcelTitleScheme titleScheme) {
        this.titleScheme = titleScheme;
    }

    public Map<String, ExcelScheme> getSchemesRows() {
        return schemesRows;
    }

    public void setSchemesRows(Map<String, ExcelScheme> schemesRows) {
        this.schemesRows = schemesRows;
    }

    public Map<String, ExcelTitleScheme> getSchemeColumns() {
        return schemeColumns;
    }

    public void setSchemeColumns(Map<String, ExcelTitleScheme> schemeColumns) {
        this.schemeColumns = schemeColumns;
    }
}
