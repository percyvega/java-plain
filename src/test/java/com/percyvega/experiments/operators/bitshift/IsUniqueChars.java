package com.percyvega.experiments.operators.bitshift;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class IsUniqueChars {

    private static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
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
        log.info("Evaluating " + s + ": " + isUniqueChars(s.toLowerCase()));
    }

}
