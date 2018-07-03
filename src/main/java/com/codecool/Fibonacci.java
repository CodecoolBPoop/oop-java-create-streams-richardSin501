package com.codecool;

import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {

    private Integer n1 = 0;
    private Integer n2 = 1;

    @Override
    public Integer get() {
        Integer fib = n1 + n2;
        n1 = n2;
        n2 = fib;
        return fib;
    }
}
