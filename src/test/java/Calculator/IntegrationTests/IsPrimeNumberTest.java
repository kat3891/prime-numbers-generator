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

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IsPrimeNumberTest {

    private Integer inputNumber;
    private Boolean expectedResult;


    public IsPrimeNumberTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 0, false },
                { 1, false },
                { 2, true },
                { 3, true },
                { 4, false },
                { 6, false },
                { 8, false },
                { 7, true },
                { 5, true },
                { 11, true },
                { 13, true },
                { 17, true },
                { 19, true },
                { 23, true },
                { 29, true },
                { 30, false },
                { 33, false },
                { 12, false },
                { 15, false },
                { 31, true },
                { 97, true },
        });
    }

    @Test
    public void isPrimeNumber() {
        assertEquals(this.expectedResult, BruteForceCalculator.isPrimeNumber(this.inputNumber));
        assertEquals(this.expectedResult, BruteForceCalculatorUsingThreads.isPrimeNumber(this.inputNumber));
        assertEquals(this.expectedResult, BruteForceCalculatorUsingStreams.isPrimeNumber(this.inputNumber));
        assertEquals(this.expectedResult, ErathostenesCalculator.isPrimeNumber(this.inputNumber));
        assertEquals(this.expectedResult, ErathostenesCalculatorUsingStreams.isPrimeNumber(this.inputNumber));
        assertEquals(this.expectedResult, ErathostenesCalculatorUsingThreads.isPrimeNumber(this.inputNumber));
    }

}