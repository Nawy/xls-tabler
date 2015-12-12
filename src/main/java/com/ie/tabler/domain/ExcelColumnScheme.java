package com.ie.tabler.domain;

import com.ie.tabler.annotation.XlsColumn;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 01:47 2015-12-12
 */
public class ExcelColumnScheme extends ExcelScheme {

    private String title;

    public ExcelColumnScheme(XlsColumn columnAnnotation, HSSFWorkbook workbook) {
        super(
                columnAnnotation.font(),
                columnAnnotation.border(),
                columnAnnotation.align(),
                workbook
        );
        title = columnAnnotation.name();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
