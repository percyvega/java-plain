package com.percyvega.experiments.operators.instanceof_app;

public class MyNumberClass extends Number {

    private String value = "0";

    public MyNumberClass(String value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return Integer.parseInt(value);
    }

    @Override
    public long longValue() {
        return Long.parseLong(value);
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(value);
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(value);
    }

}
