package test.PrimeNumberCalculator;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.PrimeNumberCalculator.IntegrationTests.GetPrimeNumbersTest;
import test.PrimeNumberCalculator.IntegrationTests.IsPrimeNumberTest;

/**
 * Perform integration tests, to check that the tool works correctly.
 *
 */
public class TestRunner {
    public static void main(String[] args) {

        Result isPrimeRes = JUnitCore.runClasses(IsPrimeNumberTest.class);
        Result getPrimesRes = JUnitCore.runClasses(GetPrimeNumbersTest.class);

        for (Failure failure : isPrimeRes.getFailures()) {
            System.out.println("IsPrimeNumberTest Failures :");
            System.out.println(failure.toString());
        }
        for (Failure failure : getPrimesRes.getFailures()) {
            System.out.println("GetPrimeNumbersTest Failures :");
            System.out.println(failure.toString());
        }

        System.out.println("IsPrimeNumberTest successful: " + isPrimeRes.wasSuccessful());
        System.out.println("GetPrimeNumbersTest successful: " + getPrimesRes.wasSuccessful());

    }
}