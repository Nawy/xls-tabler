package com.ie.tabler.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 21:03 2015-12-05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface XlsTitle {
    XlsFont font() default @XlsFont;
    XlsBorder border() default  @XlsBorder;
}
