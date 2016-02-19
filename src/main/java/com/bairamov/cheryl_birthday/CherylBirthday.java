package com.bairamov.cheryl_birthday;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/*
Альберт и Бернард только что познакомились с Шерил. Они хотят знать, когда у неё день рождения. Шерил предложила им десять возможных дат: 15 мая, 16 мая, 19 мая, 17 июня, 18 июня, 14 июля, 16 июля, 14 августа, 15 августа и 17 августа. Затем Шерил сказала Альберту месяц своего рождения, а Бернарду — день. После этого состоялся диалог.

Альберт: Я не знаю, когда у Шерил день рождения, но я знаю, что Бернард тоже не знает.
Бернард: Поначалу я не знал, когда у Шерил день рождения, но знаю теперь.
Альберт: Теперь я тоже знаю, когда у Шерил день рождения.

Когда у Шерил день рождения?
*/

public class CherylBirthday {
    private final List<Date> dates = Arrays.asList(
            Date.valueOf(15, 5), Date.valueOf(16, 5), Date.valueOf(19, 5),
            Date.valueOf(17, 6), Date.valueOf(18, 6),
            Date.valueOf(14, 7), Date.valueOf(16, 7),
            Date.valueOf(14, 8), Date.valueOf(19, 8), Date.valueOf(17, 8)
    );

    public static Date getDate() {
        return new CherylBirthday().datesLeftAfterSecondReplicaOfAlbert().findFirst().get();
    }

    private Stream<Date> datesLeftAfterSecondReplicaOfAlbert() {
        return SinglesCollector.getSingles(datesLeftAfterReplicaOfBernard(), Date::getMonth);
    }

    private Stream<Date> datesLeftAfterReplicaOfBernard() {
        return SinglesCollector.getSingles(datesLeftAfterFirstReplicaOfAlbert(), Date::getDay);
    }

    private Stream<Date> datesLeftAfterFirstReplicaOfAlbert() {
        Set<Integer> albertMonths = monthsFirstFiguredOutByAlbert();

        return dates.stream()
                .filter(date -> albertMonths.contains(date.getMonth()));
    }

    private Set<Integer> monthsFirstFiguredOutByAlbert() {
        Set<Integer> months = dates.stream()
                .map(Date::getMonth)
                .collect(toSet());

        dates.stream()
                .collect(groupingBy(Date::getDay)).entrySet().stream()
                .filter(entry -> entry.getValue().size() == 1)
                .mapToInt(entry -> entry.getValue().get(0).getMonth())
                .forEach(months::remove);

        return months;
    }
}