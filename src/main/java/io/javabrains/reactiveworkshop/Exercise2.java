package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream


        // the subscribe method is basically saying, listen to this reactive stream.
        // for every time a value is passed into it, carry out the func inside it.
        ReactiveSources.
                intNumbersFlux().
                subscribe(e -> System.out.println(e));
        
        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.
                userFlux().
                subscribe(user -> System.out.println(user));

        // this is to delay the termination of the program
        System.out.println("Press a key to end");
        System.in.read();
    }

}
