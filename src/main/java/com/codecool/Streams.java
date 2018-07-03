package com.codecool;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Streams {

    public static void main(String[] args) {
        /*
         * Create a stream out of the following array.
         */
        String[] a1 = {"one", "two", "three"};
        Stream<String> s1 = Stream.of(a1);

        /*
         * Create a stream containing the Strings "one" , "two" and "three"
         * without using an array
         */
        Stream<String> s2 = Stream.of("one", "two", "three");

        /*
         * Create a stream using a stream builder.
         */
        Stream.Builder<String> b1 = Stream.builder();
        b1.accept("one");
        b1.accept("two");
        b1.accept("three");
        Stream<String> s3 = b1.build();

        /*
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        List<String> l1 = Stream.concat(s1, Stream.concat(s2, s3)).collect(Collectors.toList());

        /*
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */

        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler);
        CharSequence charSeq1 = ", ";


        /*
         * Create a stream containing the first ten elements of s4.
         */
        Stream<Integer> s5 = s4.limit(10);
        System.out.println(
            "s5: " + s5.map(n -> n.toString()).collect(Collectors.joining(", ")));
        /*
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */
        Supplier<Integer> fibSupp = new Fibonacci();
        Stream<Integer> s6 = Stream.generate(fibSupp).limit(30);
        System.out.println(s6.collect(Collectors.toList()));
    }
}
