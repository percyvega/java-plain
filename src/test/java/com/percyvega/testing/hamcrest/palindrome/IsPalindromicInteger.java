package com.percyvega.testing.hamcrest.palindrome;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsPalindromicInteger extends TypeSafeMatcher<Integer> {

    @Override
    public void describeTo(Description description) {
        description.appendText("a palindromic integer");
    }

    @Factory
    public static Matcher<Integer> isPalindromicInteger() {
        return new IsPalindromicInteger();
    }

    @Override
    protected boolean matchesSafely(Integer num) {
        int n = num;
        int rev = 0;
        while (num > 0)
        {
            int dig = num % 10;
            rev = rev * 10 + dig;
            num = num / 10;
        }

        return n == rev;
    }
}
