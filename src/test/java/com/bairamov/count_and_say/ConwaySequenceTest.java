package com.bairamov.count_and_say;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConwaySequenceTest {
    private String input;
    private String expected;

    public ConwaySequenceTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"111221", "three 1's, then two 2's, then one 1"},
                {"11", "two 1's"},
                {"21", "one 2, then one 1"},
                {"1211", "one 1, then one 2, then two 1's"},
        });
    }

    @Test
    public void testLookAndSay() throws Exception {
        assertEquals(expected, ConwaySequence.lookAndSay(input));
    }
}