package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // this is a blocking operation
        List<Integer> numbersList = ReactiveSources.
                intNumbersFlux().
                toStream().
                toList();

        System.out.println("The numbers list is:" + numbersList);
        System.out.println("The length of the num list is: " + numbersList.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
