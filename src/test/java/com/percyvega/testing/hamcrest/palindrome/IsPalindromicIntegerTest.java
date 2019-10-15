package com.percyvega.testing.hamcrest.palindrome;

import org.junit.jupiter.api.Test;

import static com.percyvega.testing.hamcrest.palindrome.IsPalindromicInteger.isPalindromicInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class IsPalindromicIntegerTest {

    @Test
    public void testHamcrestCore() {
        assertThat(0, isPalindromicInteger());
        assertThat(11, isPalindromicInteger());
        assertThat(121, isPalindromicInteger());
        assertThat(6600066, isPalindromicInteger());
        assertThat(7772777, isPalindromicInteger());

        assertThat(1234, not(isPalindromicInteger()));
        assertThat(11121111, not(isPalindromicInteger()));
    }

}