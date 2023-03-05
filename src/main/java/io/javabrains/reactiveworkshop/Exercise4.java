package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // the subscribe method can also take multiple parameters,
        // the second param it takes is an error object in case of a failure event
        // the third argument is what is called on a completion event
        // Print the value from intNumberMono when it emits
        ReactiveSources.
                intNumberMono().
                subscribe(
                        num -> System.out.println(num),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Complete")
                );

        // Get the value from the Mono into an integer variable
        // this blocks the operation and passes the value into the number variable
        // so the operation stops until the mono returns a value
        Integer number = ReactiveSources.intNumberMono().block();

        // this blocks but returns an optional
        Optional<Integer> num = ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
