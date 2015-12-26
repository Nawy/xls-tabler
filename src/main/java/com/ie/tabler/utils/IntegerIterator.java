package com.ie.tabler.utils;

/**
 * @author Ivan Ermolaev(ermolaevym@gmail.com)
 * @since 22:56 2015-12-26
 */
public class IntegerIterator {

    private int index;

    public IntegerIterator() {
        this.index = 0;
    }

    public IntegerIterator(int beginIndex) {
        this.index = beginIndex;
    }

    public int inc() {
        return this.index++;
    }

    public int inc(int incValue) {
        int lastIndex = this.index;
        this.index += incValue;
        return lastIndex;
    }

    public int get() {
        return this.index;
    }

    public void toNull() {
        this.index = 0;
    }
}
