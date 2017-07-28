package com.percyvega.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

public class RegExTest {

    @Test
    public void characters() {
        assertFoundCount("abbc*cc", "c", 3);
        assertFoundCount("abbc*cc", "[c]", 3);

        assertFoundCount("abbc*cc", "bc", 1);
        assertFoundCount("abbc*cc", "b[c]", 1);
        assertFoundCount("abbc*cc", "[bc]", 5);
        assertFoundCount("abbc*cc", "[b]c", 1);
    }

    @Test
    public void shorthandQuantifiers() {
        assertFoundCount("abbc*cc", "c?", 8);
        assertFoundCount("abbc*cc", "[c]?", 8);
        assertFoundCount("abbc*cc", "[c?]", 3);

        assertFoundCount("abbc*cc", "c*", 7);
        assertFoundCount("abbc*cc", "[c]*", 7);
        assertFoundCount("abbc*cc", "[c*]", 4);

        assertFoundCount("abbc*cc", "c+", 2);
        assertFoundCount("abbc*cc", "[c]+", 2);
        assertFoundCount("abbc*cc", "[c+]", 3);

        assertFoundCount("abbc*cc", "bc", 1);
        assertFoundCount("abbc*cc", "b[c]", 1);
        assertFoundCount("abbc*cc", "b[c?]", 1);
        assertFoundCount("abbc*cc", "b[c*]", 1);
        assertFoundCount("abbc*cc", "b[c+]", 1);

        assertFoundCount("abbc*cc", "bc?", 2);
        assertFoundCount("abbc*cc", "b[c?]", 1);
        assertFoundCount("abbc*cc", "[bc?]", 5);
        assertFoundCount("abbc*cc", "[b]c?", 2);

        assertFoundCount("abbc*cc", "bc*", 2);
        assertFoundCount("abbc*cc", "b[c*]", 1);
        assertFoundCount("abbc*cc", "[bc*]", 6);
        assertFoundCount("abbc*cc", "[b]c*", 2);

        assertFoundCount("abbc*cc", "bc+", 1);
        assertFoundCount("abbc*cc", "b[c+]", 1);
        assertFoundCount("abbc*cc", "[bc+]", 5);
        assertFoundCount("abbc*cc", "[b]c+", 1);
    }

    @Test
    public void verboseQuantifiers() {
        assertFoundCount("run run", "run{2}", 0);
        assertFoundCount("runrun", "run{2}", 0);
        assertFoundCount("runrun", "(run){2}", 1);
        assertFoundCount("running", "run{2}", 1);
        assertFoundCount("running", "[un]{3}", 1);

        assertFoundCount("mamama", "(ma){3}", 1);
        assertFoundCount("mamama", "(ma){1}", 3);
        assertFoundCount("mamama", "(ma){2}", 1);
        assertFoundCount("ma ma ma", "(ma){1}", 3);

        assertFoundCount("mamama", "(ma){2,}", 1);
        assertFoundCount("mamama mama", "(ma){3,}", 1);
        assertFoundCount("mamama mama", "(ma){1,2}", 3);
    }

    @Test
     public void foundCount1() {
        assertFoundCount("8-7 0-9", "0-9", 1);
        assertFoundCount("5 of them (2 hidden).", "0-9", 0);

        assertFoundCount("5 of them (2 hidden).", "[0-9]", 2);

        assertFoundCount("5 of them (2 hidden).", "[4-52-5]", 2);
        assertFoundCount("5 of them (2 hidden).", "[4-5&&2-5]", 1);
        assertFoundCount("5 of them (2 hidden).", "[4-5&&[2-5]]", 1);
        assertFoundCount("5 of them (2 hidden).", "[4-5]&&[2-5]", 0);

        assertFoundCount("the (2).", "[a-zA-Z]", 3);
        assertFoundCount("the (2).", "[A-z]", 3);
        assertFoundCount("the [2).", "[a-zA-Z]", 3);
        assertFoundCount("the [2).", "[A-z]", 4);

        assertFoundCount("the [2).", "[A-z&&[^\\[\\]]]", 3);

        assertFoundCount("the [2).", "[aeiou0-9]", 2);
        assertFoundCount("the [2).", "[aeiou[0-9]]", 2);

        assertFoundCount("the [2).", "[az]", 0);
        assertFoundCount("the [2).", "[a-z]", 3);
        assertFoundCount("the [2).", "[a-z0-9]", 4);
        assertFoundCount("the [2).", "[a-z[0-9]]", 4);
        assertFoundCount("the [2).", "[a-z[^0-9]]", 7);
        assertFoundCount("the [2).", "[^0-9]", 7);

        assertFoundCount("th\\e [2)\\.", ".", 10);
        assertFoundCount("th\\e [2)\\.", "\\.", 1);
        assertFoundCount("th\\e [2)\\.", "\\Q.\\E", 1);
        assertFoundCount("th\\e [2)\\.", "\\\\", 2);
        assertFoundCount("th\\e [2)\\.", "\\Q\\\\E", 2);

        assertFoundCount("\\", "\\\\", 1);
        assertFoundCount("abcdefgh", "...", 2);
        assertFoundCount("abc...defgh", "...", 3);
        assertFoundCount("abc...defgh", "\\Q...\\E", 1);

        assertFoundCount("array[5][35]", "[35]", 3);
        assertFoundCount("array[5][35]", "[53]", 3);
        assertFoundCount("array[5][35]", "\\Q[35]\\E", 1);
        assertFoundCount("array[5][35]", "\\[35\\]", 1);

        assertFoundCount("\t\n\r\f ", "\\s", 5);
        assertFoundCount("\t\n\r\f ", "[\\s]", 5);
        assertFoundCount("\t\n\r\f ", "\\t", 1);
        assertFoundCount("\t\n\r\f ", "[\\t]", 1);

        assertFoundCount(" _abc_012_ABC_ ", "[\\w]", 13);
        assertFoundCount(" _abc_012_ABC_ ", "[\\W]", 2);
        assertFoundCount(" _abc_012_ABC_ ", "[\\s]", 2);
        assertFoundCount(" _abc_012_ABC_ ", "[\\S]", 13);
        assertFoundCount(" _abc_012_ABC_ ", "[\\d]", 3);
        assertFoundCount(" _abc_012_ABC_ ", "[\\D]", 12);

        assertFoundCount("Pablito clavó un clavito", "ito", 2);
        assertFoundCount("Pablito clavó un clavito", "(ito)", 2);
        assertFoundCount("Pablito clavó un clavito", "[ito]", 6);
        assertFoundCount("Pablito clavó un clavito", "(l|v)ito", 2);
        assertFoundCount("Pablito clavó un clavito", "[lv]ito", 2);
        assertFoundCount("Pablito clavó un clavito", "clavó|clavi", 2);
    }

    @Test
    public void foundCount2() {
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi?", 4);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)?", 4);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)?", 46);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi*", 4);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)*", 4);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)*", 46);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clavi+", 2);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav(i)+", 2);
        assertFoundCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(clavi)+", 2);
    }

    @Test
    public void caseInsensitive() {
        assertFoundCount("Run Forest, run!", "Run", 1);
        assertFoundCount("Run Forest, run!", "(?i)Run", 2);

        assertFoundCount("She said YES!", "YES", 1);
        assertFoundCount("She said YES!", "yes", 0);
        assertFoundCount("She said YES!", "(?i)yes", 1);

        assertFoundCount("She said YES!", "said (?i)yes", 1);
        assertFoundCount("She said YES!", "SAID (?i)yes", 0);
        assertFoundCount("She said YES!", "(?i)SAID yes", 1);
        assertFoundCount("She said YES!", "(?i)SAID (?-i)yes", 0);

        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(?i)(un ((clav)ito))", 3);
    }

    @Test
    public void beginningEnd() {
        assertFoundCount("run run", "run", 2);
        assertFoundCount("run run", "^run", 1);
        assertFoundCount("run run", "run$", 1);
    }

    @Test
    public void matches() {
        // matches means that it matches exactly, unlike find()
        assertMatches("Run Forest, run!", "run", false);
        assertMatches("Run Forest, run!", "((Run)(\\s\\w+), run!)", true);
    }

    @Test
    public void split() {
        assertSplitCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "clav", 5);
    }

    @Test
    public void capturingGroups() {
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un clavito", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un (clav)ito", 1);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un (clavito)", 1);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(un clavito)", 1);

        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un clavito", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un (clav)ito", 1);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un ((clav)ito)", 2);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(un ((clav)ito))", 3);

        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "((clav[^ó])|(clav[ó]))", 3);
    }

    @Test
    public void backreferences() {
        assertFoundCount("Mama said to papa, I looooove you", "[a-z]\\1", 0);
        assertFoundCount("Mama said to papa, I looooove you", "[a-z][a-z]\\1", 0);
        assertFoundCount("Mama said to papa, I looooove you", "([a-z][a-z])\\1", 2);
        assertFoundCount("Mama said to papa, I looooove you", "(?i)([a-z][a-z])\\1", 3);
        assertFoundCount("Mama said to papa, I looooove you", "(?i)([a-z][a-z])\\1", 3);
        assertFoundCount("Mama said to papa, I loooooooove you", "(?i)([a-z][a-z])\\1", 4);

        assertFoundCount("I want to go to Serres (Greece) by noon", "([a-z])([a-z])\\2\\1", 2);

        assertFoundCount("<html><body>Hello World!</body></html>", "<(\\w+)>.*</\\1>", 1);
        assertFoundCount("<head><body>Hello World!</body></html>", "<(\\w+)>.*</\\1>", 1);
    }

    @Test
    public void namedCapturingGroups() {
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "((?<diminutivo>clav[^ó])|(?<pasado>clav[ó]))", 3, true);
        //backreference
        assertFoundCount("I want to go to Serres (Greece) by noon", "(?<letter1>[a-z])(?<letter2>[a-z])\\k<letter2>\\k<letter1>", 2);
    }

    @Test
    public void nonCapturingGroups() {
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un clavito", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un (?:clav)ito", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "un (?:clavito)", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(?:un clavito)", 0);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(?:)(un clavito)", 1);
        assertCapturingGroupCount("Pablito clavó un clavito, y un clavito clavó Pablito.", "(?:un clavito)(otro)", 1);
    }

    @Test
    public void greedyQuantifiers() {
        // no quantifier
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond", 3);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.?", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{0,1}", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".?Bond", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{0,1}Bond", 3);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.*", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{0,}", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", ".*Bond", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{0,}Bond", 1);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.+", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{1,}", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", ".+Bond", 1);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{1,}Bond", 1);
    }

    @Test
    public void reluctantOrLazyQuantifiers() {
        // no quantifier
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond", 3);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.??", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{0,1}?", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".??Bond", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{0,1}?Bond", 3);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.*?", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{0,}?", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".*?Bond", 3);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{0,}?Bond", 3);

        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.+?", 2);
        assertFoundCount("Bond: My name is Bond, James Bond", "Bond.{1,}?", 2);
        assertFoundCount("Bond: My name is Bond, James Bond", ".+?Bond", 2);
        assertFoundCount("Bond: My name is Bond, James Bond", ".{1,}?Bond", 2);
    }

    @Test
    public void possessiveQuantifiers() {

    }

    private void assertCapturingGroupCount(String input, String regex, int groupCount, boolean printCapturingGroupNames) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // this doesn't make much sense
        while(matcher.find()) {
            System.out.println("Input \"" + input + "\" and regex \"" + regex + "\" found (at index " + matcher.start() + ") the following: \"" + matcher.group() + "\"");

            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println("group(" + i + "): " + matcher.group(i));

                if(printCapturingGroupNames) {
                    System.out.println("group(\"diminutivo\"): " + matcher.group("diminutivo"));
                    System.out.println("group(\"pasado\"): " + matcher.group("pasado"));
                }
            }
            System.out.println();
        }

        assertThat(matcher.groupCount()).isEqualTo(groupCount);
    }

    private void assertCapturingGroupCount(String input, String regex, int groupCount) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        assertThat(matcher.groupCount()).isEqualTo(groupCount);
    }

    private void assertSplitCount(String input, String regex, int splitCount) {
        Pattern pattern = Pattern.compile(regex);
        String[] splits = pattern.split(input);

        for (String split : splits)
            System.out.println(split);

        System.out.println();

        assertThat(splits.length).isEqualTo(splitCount);
    }

    private void assertMatches(String input, String regex, boolean isMatch) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        assertThat(matcher.matches()).isEqualTo(isMatch);
    }

    private void assertFoundCount(String input, String regex, int matchesFoundCount) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int groupCounter = 0;
        while(matcher.find()) {
            System.out.println("Input \"" + input + "\" and regex \"" + regex + "\" found (at index " + matcher.start() + ") the following: \"" + matcher.group() + "\"");
            groupCounter++;
        }

        if(groupCounter == 0) {
            System.out.println("Input \"" + input + "\" and regex \"" + regex + "\" didn't find matches.");
        }

        System.out.println();

        assertThat(groupCounter).isEqualTo(matchesFoundCount);
    }

}
