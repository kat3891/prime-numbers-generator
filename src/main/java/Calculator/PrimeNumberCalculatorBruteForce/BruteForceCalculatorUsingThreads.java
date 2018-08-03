package main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BruteForceCalculatorUsingThreads {

    /** This function determines whether the given number is a prime number.
     *   - For loop is replaced by IntStream to improve performance.
     *   - It uses multiple threads to do the calculations.
     *
     * @param number
     * @return true if the number is a prime number, false otherwise.
     */
    public static boolean isPrimeNumber(final int number) {
        if (number < 2) return false;
        return IntStream
                .rangeClosed(2, (int) (Math.sqrt(number)))
                .parallel() // multiple threads use
                .noneMatch(i -> number % i == 0); // if no integer divides the given number, return true;
    }

    /** Get the list of prime numbers between two numbers.
     *
     * @param min
     * @param max
     * @return true if the number is a prime number, false otherwise
     */
    public static List<Integer> getPrimeNumbers(final int min, final int max) {
        return IntStream.rangeClosed(min, max)
                .filter(BruteForceCalculatorUsingStreams::isPrimeNumber)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
    }
}
