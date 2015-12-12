package com.ie.tabler.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 20:56 2015-12-05
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XlsBorder {
    short size() default 0;
    short left() default 0;
    short right() default 0;
    short top() default 0;
    short bottom() default 0;
}
