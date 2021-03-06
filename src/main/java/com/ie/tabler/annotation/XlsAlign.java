package com.ie.tabler.annotation;

import com.ie.tabler.domain.ExcelAlign;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 12:02 2015-12-12
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XlsAlign {
    ExcelAlign value() default ExcelAlign.GENERAL;
}
