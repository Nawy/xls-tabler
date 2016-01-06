package com.ie.tabler.annotation;

import com.ie.tabler.domain.ExcelHorizontalAlign;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 22:39 2015-12-27
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface XlsTitle {
    String value() default "Title";
    XlsFont font() default @XlsFont;
    XlsBorder border() default @XlsBorder;
    XlsAlign align() default @XlsAlign(horizontal = ExcelHorizontalAlign.CENTER);
}
