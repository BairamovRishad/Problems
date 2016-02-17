package com.bairamov.arrayelementgetter;

import com.bairamov.utils.ObjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArrayElementGetterTest {
    private Object[] input;
    private Object expectedValue;

    public ArrayElementGetterTest(Object[] input, Object expected) {
        this.input = input;
        expectedValue = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new Object[]{new String[]{"a", "b", "c"}, 1, "d"}, "b"},
                {new Object[]{new String[]{"a", "b", "c"}, 5, "d"}, "d"},
                {new Object[]{new String[]{"a", "b", "c"}, -1, "d"}, "c"},
                {new Object[]{new String[]{"a", "b", "c"}, -5, "d"}, "d"},
                {new Object[]{new int[]{1, -5, 4, 2}, 0, 0}, 1},
                {new Object[]{new int[]{8, 0, 6, 7}, -3, -8}, 0}
        });
    }

    @Test
    public void testFetchElement() throws Exception {
        assertEquals(expectedValue, new ArrayElementGetter().fetchElement(ObjectUtils.toObjectArray(input[0]), (int) input[1], input[2]));
    }
}