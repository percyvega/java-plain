package com.percyvega.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class RegEx {

    @Test
    public void testThese() {
        printMatchingResults("abbc*cc", "c", 3);
        printMatchingResults("abbc*cc", "[c]", 3);

        printMatchingResults("abbc*cc", "c?", 8);
        printMatchingResults("abbc*cc", "[c]?", 8);
        printMatchingResults("abbc*cc", "[c?]", 3);

        printMatchingResults("abbc*cc", "c*", 7);
        printMatchingResults("abbc*cc", "[c]*", 7);
        printMatchingResults("abbc*cc", "[c*]", 4);

        printMatchingResults("abbc*cc", "c+", 2);
        printMatchingResults("abbc*cc", "[c]+", 2);
        printMatchingResults("abbc*cc", "[c+]", 3);

        printMatchingResults("abbc*cc", "bc", 1);
        printMatchingResults("abbc*cc", "b[c]", 1);
        printMatchingResults("abbc*cc", "b[c?]", 1);
        printMatchingResults("abbc*cc", "b[c*]", 1);
        printMatchingResults("abbc*cc", "b[c+]", 1);

        printMatchingResults("abbc*cc", "bc", 1);
        printMatchingResults("abbc*cc", "b[c]", 1);
        printMatchingResults("abbc*cc", "[bc]", 5);
        printMatchingResults("abbc*cc", "[b]c", 1);

        printMatchingResults("abbc*cc", "bc?", 2);
        printMatchingResults("abbc*cc", "b[c?]", 1);
        printMatchingResults("abbc*cc", "[bc?]", 5);
        printMatchingResults("abbc*cc", "[b]c?", 2);

        printMatchingResults("abbc*cc", "bc*", 2);
        printMatchingResults("abbc*cc", "b[c*]", 1);
        printMatchingResults("abbc*cc", "[bc*]", 6);
        printMatchingResults("abbc*cc", "[b]c*", 2);

        printMatchingResults("abbc*cc", "bc+", 1);
        printMatchingResults("abbc*cc", "b[c+]", 1);
        printMatchingResults("abbc*cc", "[bc+]", 5);
        printMatchingResults("abbc*cc", "[b]c+", 1);

        printMatchingResults("8-7 0-9", "0-9", 1);
        printMatchingResults("5 of them (2 hidden).", "0-9", 0);

        printMatchingResults("5 of them (2 hidden).", "[0-9]", 2);

        printMatchingResults("5 of them (2 hidden).", "[4-52-5]", 2);
        printMatchingResults("5 of them (2 hidden).", "[4-5&&2-5]", 1);
        printMatchingResults("5 of them (2 hidden).", "[4-5&&[2-5]]", 1);
        printMatchingResults("5 of them (2 hidden).", "[4-5]&&[2-5]", 0);

        printMatchingResults("the (2).", "[a-zA-Z]", 3);
        printMatchingResults("the (2).", "[A-z]", 3);
        printMatchingResults("the [2).", "[a-zA-Z]", 3);
        printMatchingResults("the [2).", "[A-z]", 4);

        printMatchingResults("the [2).", "[A-z&&[^\\[\\]]]", 3);

        printMatchingResults("the [2).", "[aeiou0-9]", 2);
        printMatchingResults("the [2).", "[aeiou[0-9]]", 2);

        printMatchingResults("the [2).", "[az]", 0);
        printMatchingResults("the [2).", "[a-z]", 3);
        printMatchingResults("the [2).", "[a-z0-9]", 4);
        printMatchingResults("the [2).", "[a-z[0-9]]", 4);
        printMatchingResults("the [2).", "[a-z[^0-9]]", 7);
        printMatchingResults("the [2).", "[^0-9]", 7);

        printMatchingResults("th\\e [2)\\.", ".", 10);
        printMatchingResults("th\\e [2)\\.", "\\.", 1);
        printMatchingResults("th\\e [2)\\.", "\\Q.\\E", 1);
        printMatchingResults("th\\e [2)\\.", "\\\\", 2);
        printMatchingResults("th\\e [2)\\.", "\\Q\\\\E", 2);

        printMatchingResults("\\", "\\\\", 1);
        printMatchingResults("abcdefgh", "...", 2);
        printMatchingResults("abc...defgh", "...", 3);
        printMatchingResults("abc...defgh", "\\Q...\\E", 1);

        printMatchingResults("array[5][35]", "[35]", 3);
        printMatchingResults("array[5][35]", "[53]", 3);
        printMatchingResults("array[5][35]", "\\Q[35]\\E", 1);
        printMatchingResults("array[5][35]", "\\[35\\]", 1);

        printMatchingResults("\t\n\r\f ", "\\s", 5);
        printMatchingResults("\t\n\r\f ", "[\\s]", 5);
        printMatchingResults("\t\n\r\f ", "\\t", 1);
        printMatchingResults("\t\n\r\f ", "[\\t]", 1);

        printMatchingResults(" _abc_012_ABC_ ", "[\\w]", 13);
        printMatchingResults(" _abc_012_ABC_ ", "[\\W]", 2);
        printMatchingResults(" _abc_012_ABC_ ", "[\\s]", 2);
        printMatchingResults(" _abc_012_ABC_ ", "[\\S]", 13);
        printMatchingResults(" _abc_012_ABC_ ", "[\\d]", 3);
        printMatchingResults(" _abc_012_ABC_ ", "[\\D]", 12);

        printMatchingResults("Pablito clavó un clavito", "ito", 2);
        printMatchingResults("Pablito clavó un clavito", "(ito)", 2);
        printMatchingResults("Pablito clavó un clavito", "[ito]", 6);
        printMatchingResults("Pablito clavó un clavito", "(l|v)ito", 2);
        printMatchingResults("Pablito clavó un clavito", "[lv]ito", 2);
        printMatchingResults("Pablito clavó un clavito", "clavó|clavi", 2);

        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi?", 4);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)?", 4);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)?", 46);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi*", 4);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)*", 4);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)*", 46);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi+", 2);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)+", 2);
        printMatchingResults("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)+", 2);

        printMatchingResults("run run", "run{2}", 0);
        printMatchingResults("runrun", "run{2}", 0);
        printMatchingResults("runrun", "(run){2}", 1);
        printMatchingResults("running", "run{2}", 1);


    }

    private void printMatchingResults(String input, String regex, int countGroups) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int groupCounter = 0;
        while(matcher.find()) {
            System.out.println("Input \"" + input + "\" and regex \"" + regex + "\" found (at index " + matcher.start() + ") " + matcher.group());
            groupCounter++;
        }

        if(groupCounter == 0) {
            System.out.println("Input \"" + input + "\" and regex \"" + regex + "\" didn't find matches.");
        }

        System.out.println();

        assertThat(groupCounter).isEqualTo(countGroups);
    }

}
