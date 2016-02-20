package com.bairamov.check_brackets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BracketsTest {
    private String input;
    private boolean expected;

    public BracketsTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"( {)  } ", false},
                {"()[]{}<>", true},
                {"<(){[]}>", true},
                {"())", false},
                {"()(", false},
                {"{)][(}", false}
        });
    }

    @Test
    public void testCheckBrackets() throws Exception {
        assertEquals(expected, Brackets.checkBrackets(input));
    }
}