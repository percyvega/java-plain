package com.percyvega.experiments.java9;

public interface PrivateDefaultInterfaceMethods {

    default float multiply(int x, int y) {
        if (isZero(x) || isZero(y)) {
            return 0;
        }
        return x * y;
    }

    // In Java 8, this would have had to be not private, but default (public)
    private boolean isZero(int x) {
        return x == 0;
    }

}
