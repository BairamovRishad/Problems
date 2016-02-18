package com.bairamov.biggest_number_former;

/*
Construct the largest possible number by arranging the integers from the given array.
Since the resulting number can be very large and out of int range, you have to represent it as string.
For example, from [3, 24, 4] we can construct 6 different numbers: 3244, 3424, 2434, 2443, 4324, 4243 and the largest of them is 4324.
*/

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BiggestNumberFormer {
    public String arrangeNumbersToFormBiggestNumber(int[] numbers) {
        return IntStream.of(numbers)
                .boxed()
                .map(Object::toString)
                .sorted(new NumberLexicographicComparator())
                .collect(Collectors.joining());
    }

    private class NumberLexicographicComparator implements Comparator<String> {

        /**
         * Lexicographically compares numbers.
         * For example,
         * in: {7, 76, 77, 78, 778, 708, 6, 777}
         * out: {78, 778, 7, 77, 777, 76, 708, 6}
         */
        @Override
        public int compare(String left, String right) {
            int lenRight = right.length();
            int lenLeft = left.length();
            int limMin = Math.min(lenRight, lenLeft);
            int limMax = Math.max(lenRight, lenLeft);
            char rightCA[] = right.toCharArray();
            char leftCA[] = left.toCharArray();

            int k1, k2;
            int k = 0;
            while (k < limMax) {
                if (k < limMin) {
                    k1 = k2 = k;
                } else {
                    if (lenRight > lenLeft) {
                        k1 = k;
                        k2 = lenLeft - 1;
                    } else {
                        k1 = lenRight - 1;
                        k2 = k;
                    }
                }

                char c1 = rightCA[k1];
                char c2 = leftCA[k2];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }

            return 0;
        }
    }
}

