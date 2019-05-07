package com.thevalenciandev.design.parkinglot.com.thevalenciandev.support;

import java.util.concurrent.Callable;

public class Thrower {

    public static Throwable exceptionFrom(Callable<?> function) {

        try {
            function.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
