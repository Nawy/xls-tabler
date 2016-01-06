package com.ie.tabler.domain;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 13:35 2016-01-06
 */
public enum ExcelVerticalAlign {

    TOP(HSSFCellStyle.VERTICAL_TOP),
    CENTER(HSSFCellStyle.VERTICAL_CENTER),
    BOTTOM(HSSFCellStyle.VERTICAL_BOTTOM),
    JUSTIFY(HSSFCellStyle.VERTICAL_JUSTIFY);

    private short value;

    private ExcelVerticalAlign(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }
}
