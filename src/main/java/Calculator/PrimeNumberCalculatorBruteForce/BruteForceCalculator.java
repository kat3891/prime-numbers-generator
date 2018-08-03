package main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce;

import java.util.ArrayList;
import java.util.List;


/**
 * ErathostenesCalculator.java
 *
 * This class provides a method to determine if a number is a prime number based on brute force calculations
 * and a method to give all prime numbers in the range between two numbers.
 *
 * @author Katia Récard
 */
public class BruteForceCalculator {



    /** This function determines whether the given number is a prime number.
     * It does bruteforce calculations, trying to find a factor of the given number. If the number can be divided,
     * one of the factors is between 2 and the square root of the number.
     *
     * @param number
     * @return true if the number is a prime number, false otherwise
     */
    public static boolean isPrimeNumber(final int number) {
        if (number < 2) return false;
        final int numberSqrt = (int) (Math.sqrt(number));
        for (int i = 2; i <= numberSqrt; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /** Get the list of prime numbers between two numbers.
     *
     * @param min
     * @param max
     * @return true if the number is a prime number, false otherwise
     */
    public static List<Integer> getPrimeNumbers(final int min, final int max) {
        /* It is best to use ArrayList instead of LinkedList as we need to get and add items fast. See the comparison
        by launching the main method of the ArrayListVsLinkedListExample class. */
       final ArrayList<Integer> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (isPrimeNumber(i)) res.add(i);
        }
        return res;
    }
}
