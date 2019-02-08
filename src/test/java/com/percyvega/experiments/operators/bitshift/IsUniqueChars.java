package com.percyvega.experiments.operators.bitshift;

public class IsUniqueChars {

    private static boolean isUniqueChars(String str) {
        int checker = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        eval("Percy");
        eval("Vega");
        eval("Castillo");
        eval("Java");
    }

    private static void eval(String s) {
        System.out.println("Evaluating " + s + ": " + isUniqueChars(s.toLowerCase()));
    }

}
