package com.bairamov.twowisemenproblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoWiseMenProblemTest {

    @Test
    public void testSolution() throws Exception {
        Pair expectedSolution = new Pair(4, 13);
        Pair actualSolution = new TwoWiseMenProblem().solution().findFirst().get();

        assertEquals(expectedSolution, actualSolution);
    }
}