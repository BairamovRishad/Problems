package com.bairamov.base_n;

/*
Check whether the number can be a n-nary number (in other words, whether the number is in base-n for n < 10).
*/

public class NumeralSystem {
    public static boolean isInBaseN(int number, int base) {

        while (true) {
            if (number == 0) {
                return true;
            }

            if ((number % 10) >= base) {
                return false;
            }
            number /= 10;
        }
    }
}
