package com.percyvega.experiments.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceRepeatedWords {

    public static void main(String[] args) {

        String regex = "(\\b[a-z]+\\b)(\\b\\s+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String input = "is is this the best best best site in inthe world ever ever";

        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            input = input.replaceAll(m.group(), m.group(1));
        }

        // Prints the modified sentence.
        System.out.println(input);
    }
}

