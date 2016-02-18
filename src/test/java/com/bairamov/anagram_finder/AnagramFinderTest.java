package com.bairamov.anagram_finder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnagramFinderTest {
    private List<String> inputWords;
    private List<List<String>> expectedAnagramsList;

    public AnagramFinderTest(List<String> input, List<List<String>> expected) {
        inputWords = input;
        expectedAnagramsList = expected;
    }

    @Parameterized.Parameters
    public static Collection data() {
        List<String> input1 = Arrays.asList("veer", "lake", "item", "kale", "mite", "ever");
        List<List<String>> expected1 = Arrays.asList(
                Arrays.asList("veer", "ever"),
                Arrays.asList("lake", "kale"),
                Arrays.asList("item", "mite")
        );

        List<String> input2 = Arrays.asList("meat", "mat", "team", "mate", "eat");
        List<List<String>> expected2 = Collections.singletonList(Arrays.asList("meat", "team", "mate"));

        return Arrays.asList(new Object[][]{
                {input1, expected1},
                {input2, expected2}
        });
    }

    @Test
    public void testGetAnagramsList() throws Exception {
        assertEquals(expectedAnagramsList, new AnagramFinder().getAnagramsList(inputWords));
    }
}