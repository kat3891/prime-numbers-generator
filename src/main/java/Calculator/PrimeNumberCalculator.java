package Calculator;

import java.util.List;

/**
 * Class to use to get primes numbers
 */
public class PrimeNumberCalculator {

    /** This function gets prime numbers in a range depending on the algorithm chosen and the range.
     * The algorithm chosen is defined by a number:
     * 1) Brute force algorithm using for loops
     * 2) Brute force algorithm using IntStreams
     * 3) Brute force algorithm using IntStreams and multiple threads
     * 3) Sieve of Erathostenes using for loops
     * 4) Sieve of Erathostenes using IntStreams
     * 6 and more) Sieve of Erathostenes using IntStreams and multiple threads
     * @param algoChosen: an int that defines the algorithm the user wants to use
     * @param min: the minimum of the range
     * @param max: the maximum of the range
     * @return the list of prime numbers in the range
     */
    public static List<Integer> getPrimeNumbers(int algoChosen, int min, int max) {
        switch (algoChosen) {
            case 1:
                return main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculator.getPrimeNumbers(min, max);
            case 2:
                return main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingStreams.getPrimeNumbers(min, max);
            case 3:
                return main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingThreads.getPrimeNumbers(min, max);
            case 4:
                return main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculator.getPrimeNumbers(min, max);
            case 5:
                return main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculatorUsingStreams.getPrimeNumbers(min, max);
            default:
                return main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculatorUsingThreads.getPrimeNumbers(min, max);
        }

    }
}
