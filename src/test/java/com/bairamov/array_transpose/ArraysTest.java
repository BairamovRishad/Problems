package com.bairamov.array_transpose;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ArraysTest {
    private Object[][] input;
    private Object[][] expected;

    public ArraysTest(Object[][] input, Object[][] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return java.util.Arrays.asList(new Object[][]{
                {new Object[][]{new Integer[]{1, 2, 3}, new String[]{":a", ":b", ":c"}},
                        new Object[][]{new Object[]{1, ":a"}, new Object[]{2, ":b"}, new Object[]{3, ":c"}}},
                {new Object[][]{new Integer[]{1, 3, 5}, new Integer[]{2, 4, 6}},
                        new Object[][]{new Object[]{1, 2}, new Object[]{3, 4}, new Object[]{5, 6}}},
                {new Object[][]{new Integer[]{1, 3, 5}},
                        new Object[][]{new Object[]{1}, new Object[]{3}, new Object[]{5}}},
                {new Object[][]{}, new Object[][]{}}
        });
    }

    @Test
    public void testTranspose() throws Exception {
        assertArrayEquals(expected, Arrays.transpose(input));
    }
}