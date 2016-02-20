package com.bairamov.check_brackets;

import java.util.*;

public class Brackets {
    final static Set<Character> opening;
    final static Collection<Character> closing;
    private static final Map<Character, Character> brackets;

    static {
        brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('<', '>');

        opening = brackets.keySet();
        closing = brackets.values();
    }

    public static boolean checkBrackets(String expression) {
        ArrayDeque<Character> charsStack = new ArrayDeque<>();

        for (char expChar : expression.toCharArray()) {
            if (opening.contains(expChar)) {
                charsStack.push(expChar);
            } else if (closing.contains(expChar)) {
                if (charsStack.isEmpty() || !isEquals(charsStack.pop(), expChar)) {
                    return false;
                }
            }
        }

        return charsStack.isEmpty();
    }

    private static boolean isEquals(char stackChar, char expChar) {
        return brackets.get(stackChar).equals(expChar);
    }
}
