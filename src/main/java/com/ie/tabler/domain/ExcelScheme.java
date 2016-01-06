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

    public ExcelScheme(Builder builder) {
        this.workbook = builder.workbook;

        this.style = workbook.createCellStyle();

        this.createBorder(builder.border);
        this.createFont(builder.font);
        this.createAlign(builder.align);
    }

    private void createBorder(XlsBorder border) {
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
    }

    private void createFont(XlsFont font) {
        if(font != null) {
            this.font = workbook.createFont();
            this.font.setFontHeightInPoints(font.size());
            this.font.setFontName(font.family());
            this.style.setFont(this.font);
        }
    }

    private void createAlign(XlsAlign align) {
        if(align != null) {
            this.style.setVerticalAlignment(align.vertical().getValue());
            this.style.setAlignment(align.horizontal().getValue());
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

    public static class Builder {
        private XlsFont font;
        private XlsBorder border;
        private XlsAlign align;
        private HSSFWorkbook workbook;

        Builder workbook(HSSFWorkbook workbook) {
            this.workbook = workbook;
            return this;
        }

        Builder font(XlsFont font) {
            this.font = font;
            return this;
        }

        Builder border(XlsBorder border) {
            this.border = border;
            return this;
        }

        Builder align(XlsAlign align) {
            this.align = align;
            return this;
        }

        ExcelScheme build() {
            return new ExcelScheme(this);
        }
    }
}
