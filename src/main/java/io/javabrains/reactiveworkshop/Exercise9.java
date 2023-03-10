package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // in this case, count() returns a Mono of type long. The reason for this is so
        // the method can be non blocking
        // the Mono is returned when there's a terminal event
        ReactiveSources.
                intNumbersFlux().
                count().
                subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        // collectList() method returns a Mono of type list.
        // collecting to a list normally would be blocking
        ReactiveSources.
                intNumbersFlux().
                collectList().
                subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        // what this does is it returns a list of the length specified
        // in this case, a list of 2 items
        ReactiveSources.
                intNumbersFlux().
                buffer(2).
                map(list -> list.get(0) + list.get(1)).
                subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
