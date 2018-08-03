package main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * ErathostenesCalculatorUsingStreams.java
 *
 * This class provides a method to determine if a number is a prime number. This method is an improvement of the method
 * used by the ErathostenesCalculator class. It uses the same algorithm (brute force calculations)
 * but uses different Java functions to do the job.
 *
 * This class also provides a method to give all prime numbers in the range between two numbers.
 *
 * @author Katia Récard
 */
public class BruteForceCalculatorUsingStreams {

    /** This function determines whether the given number is a prime number.
     *   - For loop is replaced by IntStream to improve performance.
     *
     * @param number
     * @return true if the number is a prime number, false otherwise.
     */
    public static boolean isPrimeNumber(final int number) {
        if (number < 2) return false;
        return IntStream
                .rangeClosed(2, (int) (Math.sqrt(number)))
                .noneMatch(i -> number % i == 0); // if no integer divides the given number, return true;
    }

    /** Get the list of prime numbers between two numbers.
     *   - It uses multiple threads to do the calculations.
     *   - For loop is replaced by IntStream.
     * @param min
     * @param max
     * @return true if the number is a prime number, false otherwise
     */
    public static List<Integer> getPrimeNumbers(final int min, final int max) {
        return IntStream.rangeClosed(min, max)
                .filter(i -> isPrimeNumber(i))
                .boxed()
                .collect(Collectors.toList());
    }

}
