package com.jackshenorion.thinkinjava.sample.defintf;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        System.out.println("If we use Lambda for SuperInterface, it's a normal implementation");
        SuperInterface impl2 = () -> System.out.println("We implement the run method of SuperInterface");
        impl2.run();

        System.out.println("If we use Lambda for SubInterface, " +
                "we no longer implement the method SuperInterface has. " +
                "Instead, we implement the only abstract method which SubInterface defines.");
        SuperInterface impl = (SubInterface) () -> System.out.println("We implement the subRun method of SubInterface");
        System.out.println("Even though we only implement subRun, we still can run sun method because it's a default method now:");
        impl.run();

        /**
         * Conclusion:
         * If we define a Functional Interface with Default interface(s),
         * the default interface(s) can not be used as Lambda function,
         * we need to define an abstract method.
         * Whenever we use Lambda to IMPLEMENT an Functional interface, we implement the abstract one.
         * But when we use the concrete object using Lambda, we do not necessarily use the abstract method
         * we just implements, we use the interface type defined in the method which is using it.
         */

        IntStream.range(1, 4).forEach(i -> System.out.println("Implementation 1 with value: " + i));
//        Implementation 1 with value: 1
//        Implementation 1 with value: 2
//        Implementation 1 with value: 3


        IntStream.range(1, 4).forEach((SubConsumer) (() -> System.out.println("Implementation 2")));
        // You can find that, this implementation is totally not the one above, even has no argument

//        Method accept invoked with value: 1
//        Implementation 2
//        Method accept invoked with value: 2
//        Implementation 2
//        Method accept invoked with value: 3
//        Implementation 2
    }


    @FunctionalInterface
    interface SubConsumer extends IntConsumer {
        @Override
        default void accept(int t) {
            System.out.println("Method accept invoked with value: " + t);
            subAccept();
        }

        void subAccept();
    }
}
