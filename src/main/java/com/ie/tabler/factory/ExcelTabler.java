package com.ie.tabler.factory;

import com.ie.tabler.context.ExcelContext;
import com.ie.tabler.domain.ExcelWorkbook;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 13:56 2015-12-12
 */
public class ExcelTabler {

    public static ExcelContext getWorkbook() {
        return (ExcelContext)new ExcelWorkbook();
    }
}
