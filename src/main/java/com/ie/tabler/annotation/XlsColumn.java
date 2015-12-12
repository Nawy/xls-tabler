package com.ie.tabler.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 20:58 2015-12-05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface XlsColumn {
    String name() default "Column";
    XlsFont font() default @XlsFont;
    XlsBorder border() default @XlsBorder;
    XlsAlign align() default @XlsAlign;
}
