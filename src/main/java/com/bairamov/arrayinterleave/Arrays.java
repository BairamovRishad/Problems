package com.bairamov.arrayinterleave;

/*
Construct a new array by interleaving two input arrays.
Interleaving is achieved by taking values from each array consecutively:
1st value from the 1st array, then 1st value from the 2nd array, then 2nd value from the
1st array, then 2nd value from the 2nd array, etc. Arrays can be of different lengths,
so if one arrays ends before the other, stop adding new values and return.
*/

public class Arrays {
    public static Object[] interleave(Object[] first, Object[] second) {
        int length = 2 * Math.min(first.length, second.length);
        Object[] result = new Object[length];

        for (int i = 0; i < length / 2; i++) {
            result[2 * i] = first[i];
            result[2 * i + 1] = second[i];
        }

        return result;
    }
}
