package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().
//                subscribe(
//                        num -> System.out.println(num),
//                        err -> System.out.println(err.getMessage()),
//                        () -> System.out.println("Done!")
//                );

        // The BaseBubscriber class can be used like this, instead of the lambdas written above
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}


// what this class is for is to replace the lambdas being written inside the subscribe method.
// this class can be used instead, it extends BaseSubscriber
// the class has an knows what to do for every event that happens.
class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }
}