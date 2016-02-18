package com.bairamov.array_interleave;

import com.bairamov.arrayinter_leave.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ArraysTest {
    private Object[][] input;
    private Object[] expected;

    public ArraysTest(Object[][] input, Object[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return java.util.Arrays.asList(new Object[][]{
                {new Object[][]{new Integer[]{5, 1, 3}, new String[]{"4", "9"}}, new Object[]{5, "4", 1, "9"}},
                {new Object[][]{new Integer[]{1, 3, 5}, new Integer[]{2, 4, 6}}, new Object[]{1, 2, 3, 4, 5, 6}},
                {new Object[][]{new Integer[]{1, 3, 5}, new Integer[]{2, 4}}, new Object[]{1, 2, 3, 4}},
                {new Object[][]{new Integer[]{}, new Integer[]{2, 4, 6}}, new Object[]{}}
        });
    }

    @Test
    public void testInterleave() throws Exception {
        assertArrayEquals(expected, Arrays.interleave(input[0], input[1]));
    }
}