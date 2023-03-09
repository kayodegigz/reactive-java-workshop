package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // if the log is before the filter, it logs all the elements in the incoming flux
        // if it is after the filter, it logs only the elements that pass the condition given
        ReactiveSources.
                intNumbersFlux().
                filter(e -> e > 5).
                log().
                subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
        ReactiveSources.
                intNumbersFlux().
                filter(e -> e > 5).
                map(e -> e * 10).
                subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources.
                intNumbersFlux().
                filter(e -> e > 5).
                take(3).
                map(e -> e * 10).
                subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources.
                intNumbersFlux().
                filter(e -> e > 20).
                defaultIfEmpty(-1).
                subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        // flat map was used instead of map cos the id coming from the user id cannot be mapped directly to
        // a user flux
        ReactiveSources.
                intNumbersFlux().
                flatMap(id -> ReactiveSources.userFlux().
                        filter(user -> user.getId() == id)).
                subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.
                intNumbersFluxWithRepeat().
                distinct().
                log().
                subscribe();

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.
                intNumbersFluxWithRepeat().
                distinctUntilChanged().
                log().
                subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
