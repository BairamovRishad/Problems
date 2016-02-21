package com.bairamov.count_and_say;

/*
Conway's \"Look and Say\" sequence is a sequence of numbers in which each term \"reads aloud\" the digits of the previous term.
    1 is read off as \"one 1\".
    11 is read off as \"two 1's\".
    21 is read off as \"one 2, then one 1\".
    1211 is read off as \"one 1, then one 2, then two 1's\".
*/


import java.util.HashMap;
import java.util.Map;

public class ConwaySequence<T> {
    private final Map<Integer, String> numbers;
    private T current;
    private StringBuilder sequence = new StringBuilder();
    private int counter = 0;

    private ConwaySequence() {
        numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
    }

    public static String lookAndSay(String phrase) {
        ConwaySequence conwaySeq = new ConwaySequence();
        phrase.chars().mapToObj(c -> (char) c).forEach(conwaySeq::feed);
        return conwaySeq.getSequence();
    }

    public void feed(T number) {
        if (current != null && !number.equals(current)) {
            adjustSequence();
            counter = 0;
        }

        current = number;
        counter++;
    }

    public String getSequence() {
        adjustSequence();
        return sequence.toString();
    }

    private void adjustSequence() {
        if (sequence.length() != 0) {
            sequence.append(", then ");
        }

        sequence.append(numbers.get(counter));
        sequence.append(" ");
        sequence.append(current);

        if (counter > 1) {
            sequence.append("'s");
        }
    }
}
