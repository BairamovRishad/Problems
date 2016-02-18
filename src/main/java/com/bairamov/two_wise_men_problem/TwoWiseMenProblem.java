package com.bairamov.two_wise_men_problem;

import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
У некоторого султана было два мудреца: Али-ибн-Вали и Вали-ибн-Али. Желая убедиться в их мудрости, султан призвал мудрецов
к себе и сказал: «Я задумал два числа. Оба они целые, каждое больше единицы, но меньше ста. Я перемножил эти числа и
результат сообщу Али и при этом Вали я скажу сумму этих чисел. Если вы и вправду так мудры, как о вас говорят,
то сможете узнать исходные числа».

Мудрецы задумались. Первым нарушил молчание Али.
— Я не знаю этих чисел, — сказал он, опуская голову.
— Я это знал, — подал голос Вали.
— Тогда я знаю эти числа, — обрадовался Али.
— Тогда и я знаю! — воскликнул Вали.
И мудрецы сообщили пораженному царю задуманные им числа.

Назовите эти числа.
*/

public class TwoWiseMenProblem {
    private final PrimesManager primeManager = new PrimesManager();

    public static void main(String[] args) {
        TwoWiseMenProblem twoWiseMenProblem = new TwoWiseMenProblem();

        System.out.println("Vali's possible numbers: " + twoWiseMenProblem.valiNumbers().limit(20).boxed().collect(Collectors.toList()));
        System.out.println("Ali's possible numbers: " + twoWiseMenProblem.aliNumbers().limit(30).boxed().collect(Collectors.toList()));
        Pair solution = twoWiseMenProblem.solution()
                .peek(pair -> System.out.println("Ali's number: " + pair.getProduct() + "; Vali's number: " + pair.getSum() + "; pair: " + pair.getX() + " & " + pair.getY()))
                .findFirst().get();
        System.out.println("Is solution correct? " + twoWiseMenProblem.checkSolution(solution));
    }

    public IntStream valiNumbers() {
        return IntStream
                .iterate(4, i -> i + 1)
                .filter(i -> !expandBySum(i)
                        .anyMatch(pair -> primeManager.isPrime(pair.getX()) && primeManager.isPrime(pair.getY())));
    }

    public IntStream aliNumbers() {
        return IntStream
                .iterate(4, i -> i + 1)
                .filter(sum -> expandByProd(sum)
                        .filter(pair -> isInValiNumbers(pair.getSum()))
                        .count() == 1);
    }

    public Stream<Pair> solution() {
        return valiNumbers()
                .mapToObj(valiNumber -> expandBySum(valiNumber)
                        .filter(p -> isInAliNumbers(p.getProduct()))
                        .collect(Collectors.toList()))
                //.peek(System.out::println)
                .filter(x -> x.size() == 1)
                .map(x -> x.get(0));
    }

    public boolean checkSolution(Pair pair) {
        return expandBySum(pair.getSum())
                .filter(p -> isInAliNumbers(p.getProduct()))
                .count() == 1;
    }

    private Stream<Pair> expandBySum(int sum) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int x = 2; x <= sum / 2; x++) {
            for (int y = x; y <= (sum - 2); y++) {
                Pair pair = new Pair(x, y);
                if (pair.getSum() == sum) {
                    pairs.add(pair);
                }
            }
        }
        return pairs.stream();
    }

    private Stream<Pair> expandByProd(int prod) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int x = 2; x <= Math.sqrt(prod); x++) {
            for (int y = x; y <= (prod / 2); y++) {
                Pair pair = new Pair(x, y);
                if (pair.getProduct() == prod) {
                    pairs.add(pair);
                }
            }
        }
        return pairs.stream();
    }

    private boolean isInValiNumbers(int number) {
        return isInNumbers(number, valiNumbers());
    }

    private boolean isInAliNumbers(int number) {
        return isInNumbers(number, aliNumbers());
    }

    private boolean isInNumbers(int x, IntStream numbers) {
        PrimitiveIterator.OfInt iterator = numbers.iterator();

        while (iterator.hasNext()) {
            int i = iterator.nextInt();
            if (i == x) {
                return true;
            } else if (i > x) {
                break;
            }
        }

        return false;
    }
}