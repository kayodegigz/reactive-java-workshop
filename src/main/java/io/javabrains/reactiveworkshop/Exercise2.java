package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream


        // the subscribe method is basically saying, listen to this reactive stream.
        // for every time a value is passed into it, carry out the func inside it.
        // the subscribe method can also take multiple parameters,
        // the second param it takes is an error object in case of a failure event
        // the third argument is what is called on a completion event
        // Print the value from intNumberMono when it emits
        ReactiveSources.
                intNumbersFlux().
                subscribe(
                        num -> System.out.println(num),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Complete")
                );

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.
                userFlux().
                subscribe(user -> System.out.println(user));

        // this is to delay the termination of the program
        System.out.println("Press a key to end");
        System.in.read();
    }

}
