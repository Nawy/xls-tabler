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
        super(
                titleAnnotation.font(),
                titleAnnotation.border(),
                titleAnnotation.align(),
                workbook
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
