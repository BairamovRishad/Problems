package com.bairamov.cheryl_birthday;

import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public abstract class SinglesCollector {
    public static <T, K> Stream<T> getSingles(Stream<T> source, Function<? super T, ? extends K> classifier) {
        return source
                .collect(groupingBy(classifier)).entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(entry -> entry.getValue().get(0));
    }
}
