package com.ie.tabler.domain;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 12:50 2015-12-06
 */
public class FieldObject {

    private Field field;
    private Method getter;
    private Object instance;

    public FieldObject(Field field, Object instance) throws NoSuchMethodException {

        this.field = field;
        this.instance = instance;

        String fieldName = field.getName();
        String getterName = "get"
                + fieldName.substring(0,1).toUpperCase()
                + fieldName.substring(1);
        getter = instance.getClass().getMethod(getterName, null);
        getter.setAccessible(true);
    }

    public Object getValue() throws InvocationTargetException, IllegalAccessException {
        return getter.invoke(instance,null);
    }

    public Field getField() {
        return field;
    }

    public Method getGetter() {
        return getter;
    }

    public Object getInstance() {
        return instance;
    }
}
