package test.PrimeNumberCalculator.IntegrationTests;


import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculator;
import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingStreams;
import main.PrimeNumberCalculator.PrimeNumberCalculatorBruteForce.BruteForceCalculatorUsingThreads;
import main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculator;
import main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculatorUsingStreams;
import main.PrimeNumberCalculator.SieveOfErathosthenes.ErathostenesCalculatorUsingThreads;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.util.Arrays.asList;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class GetPrimeNumbersTest {

    private Integer inputMin;
    private Integer inputMax;
    private List<Integer> expectedResult;


    public GetPrimeNumbersTest(Integer inputMin, Integer inputMax, List<Integer> expectedResult) {
        this.inputMin = inputMin;
        this.inputMax = inputMax;
        this.expectedResult = expectedResult;
    }


    @Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 0, 10, asList(2,3,5,7) },
                { 5, 20, asList(5,7, 11, 13, 17, 19)},
                { 8, 23, asList(11, 13, 17, 19, 23)} ,
                { 20, 100, asList(23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)},
                { 23, 100, asList(23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)},
                { 61, 97, asList(61, 67, 71, 73, 79, 83, 89, 97)},
                { 12, 60, asList(13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59)},
        });
    }

    @Test
    public void getPrimeNumbersTest() {
        assertEquals(this.expectedResult, BruteForceCalculator.getPrimeNumbers(this.inputMin, this.inputMax));
        assertEquals(this.expectedResult, BruteForceCalculatorUsingThreads.getPrimeNumbers(this.inputMin, this.inputMax));
        assertEquals(this.expectedResult, BruteForceCalculatorUsingStreams.getPrimeNumbers(this.inputMin, this.inputMax));
        assertEquals(this.expectedResult, ErathostenesCalculator.getPrimeNumbers(this.inputMin, this.inputMax));
        assertEquals(this.expectedResult, ErathostenesCalculatorUsingStreams.getPrimeNumbers(this.inputMin, this.inputMax));
        assertEquals(this.expectedResult, ErathostenesCalculatorUsingThreads.getPrimeNumbers(this.inputMin, this.inputMax));
    }

}