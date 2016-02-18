package com.bairamov.bob;

/*
Bob answers 'Sure.' if you ask him a question.
He answers 'Whoa, chill out!' if you yell at him.
He says 'Fine. Be that way!' if you address him without actually saying anything.
He answers 'Whatever.' to anything else.
*/

public class Bob {
    public static String answer(String sentence) {
        long lettersCount = sentence.chars().filter(Character::isLetter).count();
        long uppercaseLettersCount = sentence.chars().filter(c -> Character.isLetter(c) && Character.isUpperCase(c)).count();

        if ((lettersCount != 0) && (lettersCount == uppercaseLettersCount))
            return "Whoa, chill out!";
        if (sentence.endsWith("?"))
            return "Sure.";
        if (sentence.trim().isEmpty())
            return "Fine. Be that way!";
        return "Whatever.";
    }
}
