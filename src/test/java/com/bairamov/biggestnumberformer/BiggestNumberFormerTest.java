package com.bairamov.biggestnumberformer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BiggestNumberFormerTest {
    private int[] inputNumbers;
    private String expectedBiggestNumber;

    public BiggestNumberFormerTest(int[] input, String expected) {
        inputNumbers = input;
        expectedBiggestNumber = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 34, 3, 98, 9, 76, 45, 4}, "998764543431"},
                {new int[]{1, 2, 3, 4, 5, 6}, "654321"},
                {new int[]{481, 428, 385, 202, 2, 197, 106, 10}, "481428385220219710610"},
                {new int[]{54, 546, 548, 60}, "6054854654"},
                {new int[]{43, 44, 12, 324, 90, 9, 88, 89}, "9908988444332412"},
                {new int[]{7, 76, 77, 78, 778, 708, 6, 777}, "78778777777767086"}
        });
    }

    @Test
    public void testArrangeNumbersToFormBiggestNumber() throws Exception {
        assertEquals(expectedBiggestNumber, new BiggestNumberFormer().arrangeNumbersToFormBiggestNumber(inputNumbers));
    }
}