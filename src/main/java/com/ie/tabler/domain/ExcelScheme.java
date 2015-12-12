package com.ie.tabler.domain;

import com.ie.tabler.annotation.XlsAlign;
import com.ie.tabler.annotation.XlsBorder;
import com.ie.tabler.annotation.XlsFont;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 21:56 2015-12-11
 */
public class ExcelScheme {
    private HSSFFont font;
    private HSSFCellStyle style;
    private HSSFWorkbook workbook;

    public ExcelScheme(XlsFont font, XlsBorder border, XlsAlign align, HSSFWorkbook workbook) {
        this.workbook = workbook;

        this.style = workbook.createCellStyle();
        if(border != null) {
            if(border.left() == 0 && border.right() == 0 && border.top() == 0 && border.bottom() == 0)
            {
                this.style.setBorderRight(border.size());
                this.style.setBorderLeft(border.size());
                this.style.setBorderTop(border.size());
                this.style.setBorderBottom(border.size());
            }
            else {
                this.style.setBorderRight(border.right());
                this.style.setBorderLeft(border.left());
                this.style.setBorderTop(border.top());
                this.style.setBorderBottom(border.bottom());
            }
        }

        if(font != null) {
            this.font = workbook.createFont();
            this.font.setFontHeightInPoints(font.size());
            this.font.setFontName(font.family());
            this.style.setFont(this.font);
        }

        if(align != null) {
            this.style.setAlignment(align.value().getValue());
        }
    }

    public HSSFFont getFont() {
        return font;
    }

    public void setFont(HSSFFont font) {
        this.font = font;
    }

    public HSSFCellStyle getStyle() {
        return style;
    }

    public void setStyle(HSSFCellStyle style) {
        this.style = style;
    }
}
