package test.PrimeNumberCalculator.PerformanceTests;

import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculator;
import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingStreams;
import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingThreads;
import main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculatorUsingStreams;
import main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculator;

/** This class compares performances between each algorithm that is used to find every prime
 * number in a range.
 *
 * Results:
 *    - Using streams instead of for loops increases the calculations times for the sieve of Erathostenes.
 *    - Using multiple threads reduces the calculation times.
 *    - The sieve of Erathostenes is more efficient than the brute force algorithm (with for loops).
 *    - For huge numbers, it is best to use the brute force algorithm with IntStream and multiple threads
 *    than the sieve of Erathostenes with only IntStreams
 *
 *    - The best algorithm is the sieve of Erathostenes with for loops.
 *    - The worst algorithms are those using java streams without multiple threads for huge numbers
 *    - If the brute force algorithm must be chosen, it is best to use streams and multi threading than with the for loop,
 *    even if it takes more time (but remains small) to do calculations for small numbers
 *
 */
public class AlgorithmPerformanceComparisons {

    public static void main(String[] args) {

        System.out.println("Comparing prime number calculator algorithms");

        int min = 300;

            for (int max = 1000; max < 100000000 ; max*=10) {

                System.out.println(String.format("\n \nRange : %d -- %d \n", min, max));

                long start = System.currentTimeMillis();
                BruteForceCalculator.getPrimeNumbers(min, max);
                long totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Brute force calculations: %d ms", totalTimeMs));


                start = System.currentTimeMillis();
                BruteForceCalculatorUsingStreams.getPrimeNumbers(min, max);
                totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Brute force calculations using Java streams: %d ms", totalTimeMs));


                start = System.currentTimeMillis();
                BruteForceCalculatorUsingThreads.getPrimeNumbers(min, max);
                totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Brute force calculations using Java streams and threads: %d ms", totalTimeMs));


                start = System.currentTimeMillis();
                ErathostenesCalculator.getPrimeNumbers(min, max);
                totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Sieve of Erathosthenes: %d ms", totalTimeMs));

                start = System.currentTimeMillis();
                ErathostenesCalculatorUsingStreams.getPrimeNumbers(min, max);
                totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Sieve of Erathosthenes using Java streams: %d ms", totalTimeMs));

                start = System.currentTimeMillis();
                BruteForceCalculatorUsingThreads.getPrimeNumbers(min, max);
                totalTimeMs = System.currentTimeMillis() - start;
                System.out.println(String.format("Sieve of Erathosthenes using Java streams and threads: %d ms", totalTimeMs));

                min = min * 10;
            }


    }

}
