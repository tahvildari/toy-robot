package com.iress.entity.table;

/**
 * The Table class is designed to keep the dimensions of the table.
 * Based on the requirement, it can be extended in the way that lets to initialize at startup .
 */

public class Table {
    private static int width = 5;
    private static int length = 5;

    private Table() {
        throw new IllegalStateException("Table class cannot be instantiated.");
    }

    /**
     * Change the dimension of the table on start up
     *
     * @param width  width of the table
     * @param length length of the table
     */
    public static void setWidth(int width, int length) {
        setWidth(width);
        setLength(length);
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Table.width = width;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Table.length = length;
    }
}
