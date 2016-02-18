package com.bairamov.anagram_finder;

import java.util.*;

/*
Find all the anagrams in a vector of words.
Your function should return a vector of vectors, where each sub-vector is a group of words which are anagrams of each other.
Words without any anagrams should not be included in the result.
*/

public class AnagramFinder {
    public List<List<String>> getAnagramsList(List<String> words) {
        List<List<String>> anagramsList = new ArrayList<>();

        Map<String, List<String>> anagramsMap = new LinkedHashMap<>();

        for (String word : words) {
            String sorted = sortString(word);

            if (!anagramsMap.containsKey(sorted)) {
                anagramsMap.put(sorted, new ArrayList<>());
            }
            anagramsMap.get(sorted).add(word);
        }

        anagramsMap.values().stream().filter(anagrams -> anagrams.size() > 1).forEach(anagramsList::add);

        return anagramsList;
    }

    private String sortString(String word) {
        char[] wordLetters = word.toCharArray();
        Arrays.sort(wordLetters);
        return String.valueOf(wordLetters);
    }
}
