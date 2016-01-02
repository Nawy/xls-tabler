package com.ie.tabler.domain;

import com.ie.tabler.annotation.XlsTitle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 01:47 2015-12-12
 */
public class ExcelTitleScheme extends ExcelScheme {

    private String title;

    public ExcelTitleScheme(XlsTitle titleAnnotation, HSSFWorkbook workbook) {
        super(new ExcelScheme.Builder()
                        .workbook(workbook)
                        .border(titleAnnotation.border())
                        .font(titleAnnotation.font())
                        .align(titleAnnotation.align())
        );
        title = titleAnnotation.value();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
