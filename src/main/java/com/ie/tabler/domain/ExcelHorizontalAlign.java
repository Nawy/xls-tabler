package com.ie.tabler.domain;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 11:54 2015-12-12
 */
public enum ExcelHorizontalAlign {
    CENTER(HSSFCellStyle.ALIGN_CENTER),
    CENTER_SELECTION(HSSFCellStyle.ALIGN_CENTER_SELECTION),
    FILL(HSSFCellStyle.ALIGN_FILL),
    GENERAL(HSSFCellStyle.ALIGN_GENERAL);

    private short value;

    private ExcelHorizontalAlign(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }

}
