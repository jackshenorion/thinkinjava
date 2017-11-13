package com.jackshenorion.thinkinjava.sample.defintf;

@FunctionalInterface
public interface SubInterface extends SuperInterface {

    @Override
    default void run() {
        System.out.println("This is method of SuperInterface");
        subRun();
    }

    void subRun();
}
