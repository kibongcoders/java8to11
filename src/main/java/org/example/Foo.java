package org.example;

import java.util.Locale;
import java.util.function.Function;

public interface Foo extends Function<Integer, Integer> {

    void printName();

    String getName();

    default void upperCaseString() {
        System.out.println(getName().toUpperCase());
    }
}
