package CommandLineInterface;

import Calculator.PrimeNumberCalculator;
import Calculator.exceptions.RangeOutOfReachException;
import Calculator.exceptions.WrongRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Defines a command line interface for users. He can get primes numbers in some range as long as he wants, and must
 * chose an algorithm to do the calculations.
 */
public class CliInterface {

    /**
     * Determines all prime numbers in a range given by the user.
     *
     * @param args No args need to be given
     */
    public static void main(String[] args) {

        final String SEPARATOR = "-------------------------------";

        System.out.println("Prime Numbers Generator");
        System.out.println("Determines all prime numbers in a range");
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        boolean keepGoing = true;

        // loop that stops when the user does not want to use the programm anymore
        while (keepGoing) {
            System.out.println(SEPARATOR);

            // prompt to get the range
            System.out.println("Give the range minimum");
            final int min = scanner.nextInt();
            System.out.println("Give the range maximum");
            final int max = scanner.nextInt();

            System.out.println("Choose an algorithm");
            System.out.println("    1) Brute force calculations");
            System.out.println("    2) Brute force calculations using Java streams");
            System.out.println("    3) Brute force calculations using Java streams and threads");
            System.out.println("    4) Sieve of Erathostenes");
            System.out.println("    5) Sieve of Erathostenes using Java streams");
            System.out.println("    6) Sieve of Erathostenes using Java streams and threads");


            final int level = scanner.nextInt();
            System.out.println(SEPARATOR);
            try {
                final List<Integer> res = PrimeNumberCalculator.getPrimeNumbers(level, min, max);
                // determines all prime numbers in the range
                // display the result
                System.out.println(String.format("Between %d and %d, there are %d prime numbers", min, max, res.size()));
                System.out.println(Arrays.toString(res.toArray()));
            } catch (WrongRangeException e) {
                System.out.println("The minimum and the maximum range must be swapped");
            } catch (RangeOutOfReachException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(SEPARATOR);
            System.out.println("Exit ? ");
            System.out.println("0) No");
            System.out.println("1) Yes");

            keepGoing = scanner.nextInt() == 0;

        }
    }
}
