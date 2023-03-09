package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.
                intNumbersFluxWithException().
                subscribe(num -> System.out.println(num),
                        err -> System.out.println("Error Occurred!"));

        //OR
        // however in this case, the error is not exactly caught, the full stack trace is printed
        // unless it is handled in the subscribe method
        // but the doOnError() method is like an instruction to carry out immediately an
        // error is encountered
        ReactiveSources.
                intNumbersFluxWithException().
                doOnError(err -> System.out.println("Error!" + err.getMessage())).
                subscribe(num -> System.out.println(num));


        // Print values from intNumbersFluxWithException and continue on errors
        // this just means when an error happens, the error would be caught and handled
        // but the flux would continue operations on the next item
        ReactiveSources.
                intNumbersFluxWithException().
                onErrorContinue((err, item) -> System.out.println("Error!" + err.getMessage())).
                subscribe(num -> System.out.println(num));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // what happens here is once an error happens, replace the old flux with a new one and stream it
        ReactiveSources.
                intNumbersFluxWithException().
                onErrorResume(err -> Flux.just(-1, -2)).
                subscribe(num -> System.out.println(num));


        // the doFinally() is used here. It is similar to the try-catch finally
        // it does not run when an element is emitted
        // only when there is a terminal event, whether complete or failed
        ReactiveSources.
                intNumbersFluxWithException().
                doFinally(signalType -> {
                    if (signalType == SignalType.ON_COMPLETE) {
                        System.out.println("A complete signal!");
                    } else if (signalType == SignalType.ON_ERROR) {
                        System.out.println("A failure or error signal!!!");
                    }
                }).
                subscribe(num -> System.out.println(num));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
