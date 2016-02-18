package com.bairamov.array_fetch;

/*
Given an array, an index, and a default value as input, return the element by that index; if no element exists with given index then return the default value.
Index can be a negative integer, which means going over the array backwards from the end.
*/

public class Arrays {
    public static <T> T fetchElement(T[] array, int index, T defaultValue) {
        if (Math.abs(index) >= array.length)
            return defaultValue;

        if (index < 0)
            index = array.length + index;

        return array[index];
    }
}
