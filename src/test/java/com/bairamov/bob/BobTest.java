package com.bairamov.bob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BobTest {
    private String input;
    private String expected;

    public BobTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"1, 2, 3 GO!", "Whoa, chill out!"},
                {"ZOMBIES ARE COMING!!11!!1!", "Whoa, chill out!"},
                {"WHAT THE HELL WERE YOU THINKING?", "Whoa, chill out!"},
                {"It is OK.", "Whatever."},
                {"Ending with ? means a question.", "Whatever."},
                {"", "Fine. Be that way!"},
                {"    ", "Fine. Be that way!"},
                {"4?", "Sure."},
        });
    }

    @Test
    public void testAnswer() throws Exception {
        assertEquals(expected, Bob.answer(input));
    }
}