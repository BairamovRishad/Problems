package com.bairamov.base_n;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NumeralSystemTest {
    private int[] input;
    private boolean expected;

    public NumeralSystemTest(int[] input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{6161, 3}, false},
                {new int[]{1010, 2}, true},
                {new int[]{2341, 4}, false},
                {new int[]{5511, 8}, true},
        });
    }

    @Test
    public void testIsInBaseN() throws Exception {
        assertEquals(expected, NumeralSystem.isInBaseN(input[0], input[1]));
    }
}