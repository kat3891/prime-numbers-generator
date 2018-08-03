package main.PrimeNumberCalculator.SieveOfErathosthenes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ErathostenesCalculatorUsingThreads {

    public static boolean isPrimeNumber(final int number) {
        return getPrimeNumbers(number, number).size() != 0;
    }


    public static List<Integer> getPrimeNumbers(final int min, final int max) {

        boolean prime[] = new boolean[max + 1];
        Arrays.fill(prime, true);
        int squareRootMax = (int) Math.sqrt(max);
        IntStream.rangeClosed(2, squareRootMax)
                .parallel()
                .filter(i -> prime[i])
                .forEach( i -> {
                    final int x = i;
                    IntStream.rangeClosed(x * 2, max)
                            .parallel()
                            .filter(j -> j % x == 0)
                            .forEach(j -> prime[j] = false);
                });
        return IntStream.rangeClosed(Math.max(min, 2), max)
                .filter(i -> prime[i])
                .parallel()
                .boxed()
                .collect(Collectors.toList());
    }
}
