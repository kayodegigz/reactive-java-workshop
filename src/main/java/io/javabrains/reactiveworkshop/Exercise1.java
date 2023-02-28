package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("The int numbers stream are:");
        StreamSources.intNumbersStream().
                forEach(num -> System.out.println(num));


        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("The int numbers stream that are less than 5 are:");
        StreamSources.intNumbersStream().
                filter(num -> num < 5).
                forEach(num -> System.out.println(num));


        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("The 2nd and 3rd int numbers stream that are greater than 5:");
        StreamSources.intNumbersStream().
                filter(num -> num > 5).
                skip(1).
                limit(2).
                forEach(num -> System.out.println(num));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("The 1st int numbers stream that is greater than 5:");
        Integer first_num = StreamSources.intNumbersStream().
                filter(num -> num > 5).
                findFirst().
                orElse(-1);
        System.out.println(first_num);


        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("The first names of all the users in userStream are:");
        StreamSources.userStream().
                forEach(user -> System.out.println(user.getFirstName()));
        // OR this
        StreamSources.userStream().
                map(user -> user.getFirstName()).
                forEach(userName -> System.out.println(userName));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("First names in userstream that have ids from num stream:");
        StreamSources.intNumbersStream().
                forEach(num -> StreamSources.userStream().
                        filter(user -> user.getId() == num).
                        forEach(u -> System.out.println(u.getFirstName())));

    }

}
