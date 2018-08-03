package test.PrimeNumberCalculator.PerformanceTests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayListVsLinkedListExample.java
 * This class tests how long it takes to add and get an element in an ArrayList and in a LinkedList.
 * Results: At the end, it is better to use ArrayList for the CliInterface.
 *
 * @author Katia Récard
 */

public class ArrayListVsLinkedListExample {

    private static final int ELCOUNT = 50000;

    public static void main(String[] args) {

        List<String> alist = new ArrayList<String>();
        List<String> llist = new LinkedList<String>();

        // INSERTION - ArrayList
        long start = System.currentTimeMillis();
        for (int i = 0; i < ELCOUNT; i++) {
            alist.add("element #" + i);
        }
        long totalTimeMs = System.currentTimeMillis() - start;
        System.out.println(String.format("Adding 50K elements in ArrayList took %d ms", totalTimeMs));

        // INSERTION - LinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < ELCOUNT; i++) {
            llist.add("element #" + i);
        }
        totalTimeMs = System.currentTimeMillis() - start;
        System.out.println(String.format("Adding 50K elements in LinkedList took %d ms",totalTimeMs));


        // GET - ArrayList
        start = System.currentTimeMillis();
        for (int i = 0; i < ELCOUNT; i++) {
            alist.get(i);
        }
        totalTimeMs = System.currentTimeMillis() - start;
        System.out.println(String.format("Getting 50K elements in ArrayList took %d ms", totalTimeMs));

        // GET - LinkedList
        start = System.currentTimeMillis();
        for (int i = 0; i < ELCOUNT; i++) {
            llist.get(i);
        }
        totalTimeMs = System.currentTimeMillis() - start;
        System.out.println(String.format("Getting 50K elements in LinkedList took %d ms", totalTimeMs));
    }

}