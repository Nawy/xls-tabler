package com.ie.tabler.test.common;

import com.ie.tabler.annotation.*;
import com.ie.tabler.domain.ExcelHorizontalAlign;

import java.math.BigDecimal;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 21:28 2015-12-05
 */
@XlsTable
@XlsTitle("Beautiful Cars")
public class CarsTable {

    @XlsTitle(
            value = "Mark",
            font = @XlsFont(size = 20, family = "Serif"),
            border = @XlsBorder(size = 2))
    @XlsFont(
            size = 15,
            family = "Serif"
    )
    @XlsBorder(size = 1)
    @XlsAlign(horizontal = ExcelHorizontalAlign.CENTER)
    private String mark;

    @XlsTitle(
            value = "Price",
            font = @XlsFont(size = 20, family = "Serif")
    )
    @XlsFont(
            size = 15,
            family = "Serif"
    )
    private BigDecimal price;

    @XlsTitle(
            value = "Status",
            font = @XlsFont(size = 20, family = "Serif")
    )
    @XlsFont(
            size = 15,
            family = "Arial"
    )
    private String status;

    public CarsTable(String mark, BigDecimal price, String status) {
        this.mark = mark;
        this.price = price;
        this.status = status;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
