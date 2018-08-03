package main.PrimeNumberCalculator.SieveOfErathosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ErathostenesCalculatorUsingStreams.java
 *
 * This class provides a method to determine if a number is a prime number, using the sieve of Erathosthenes,
 * and a method to give all prime numbers in the range between two numbers.
 *
 * @author Katia Récard
 */
public class ErathostenesCalculator {

    public static boolean isPrimeNumber(final int number) {
        return getPrimeNumbers(number, number).size() != 0;
    }


    public static List<Integer> getPrimeNumbers(final int min, final int max) {

        boolean prime[] = new boolean[max + 1];
        Arrays.fill(prime, true);
        int squareRootMax = (int) Math.sqrt(max);

        for (int i = 2 ; i <= squareRootMax; i++) {
            if (prime[i]) {
                for (int j = i * 2 ; j <= max; j+= i) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = Math.max(min, 2); i <= max; i++) {
            if (prime[i]) res.add(i);
        }
        return res;
    }





}
