package com.bairamov.two_wise_men_problem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimesManager {
    private int CACHE_THRESHHOLD = 100;
    private List<Integer> cachedPrimes = primeThresholdedSequence(CACHE_THRESHHOLD).boxed().collect(Collectors.toList());

    public IntStream primeFixedSizeSequence(int size) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(x -> isPrime(x))
                .limit(size);
    }

    public IntStream primeThresholdedSequence(int max) {
        return IntStream.rangeClosed(2, max)
                .filter(x -> isPrime(x));
    }

    public boolean isPrime(int x) {
        if (cachedPrimes != null && x <= CACHE_THRESHHOLD) {
            return cachedPrimes.contains(x);
        }

        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }
}