package Calculator;

import Calculator.exceptions.RangeOutOfReachException;
import Calculator.exceptions.WrongRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class to use to get primes numbers
 */
public class PrimeNumberCalculator {

    // we define a maximum value to the range to prevent DoS attacks
    private static final int MAX_POSSIBLE = 1000000;

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
    public static List<Integer> getPrimeNumbers(final int algoChosen, final int min, final int max) throws WrongRangeException {
        if (min > max) throw new WrongRangeException(String.format("The minimum %d must be lower than the maximum %d", min, max));
        if (max > MAX_POSSIBLE) throw new RangeOutOfReachException(String.format("Range can not go beyond %d", MAX_POSSIBLE));
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

    /** Get the algorithm name depending on its identifier. If the identifier does not correspond to an algorithm,
     * it returns the list of algorithms associated to its identifier.
     *
     * @param algo: the algorithm identifier
     * @return the algorithm name
     */
    public static String getAlgorithmName(final int algo) {
        switch (algo) {
            case 1:
                return "Brute force algorithm with for loops";
            case 2:
                return "Brute force algorithm with java streams";
            case 3:
                return "Brute force algorithm with java streams and multiple threads";
            case 4:
                return "Sieve of Erathostenes with for loops";
            case 5:
                return "Sieve of Erathostenes with java streams";
            case 6:
                return "Sieve of Erathostenes with java streams and multiple threads";
            default:
                return IntStream.rangeClosed(1, 6).mapToObj(i -> String.format("%s)     %s \n", i, getAlgorithmName(i))).collect(Collectors.joining());
        }
    }
}
