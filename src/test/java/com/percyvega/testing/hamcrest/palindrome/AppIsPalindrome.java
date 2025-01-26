package com.percyvega.testing.hamcrest.palindrome;

import com.percyvega.datastructure.arraylist.ArrayList;
import lombok.extern.log4j.Log4j2;

/**
 * Created by percy on 4/29/2017.
 */
@Log4j2
public class AppIsPalindrome {

    public static void main(String[] args) {
        isPalindrome(234652);
        isPalindrome(235532);
        isPalindrome(225522);
        isPalindrome(123123);
        isPalindrome(999999);
        isPalindrome(999333);
        isPalindrome(232323);
        isPalindrome(11311);
        isPalindrome(11111);
        isPalindrome(11151);
    }

    private static void isPalindrome(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i *= 10) {
            int digit = (n % (i * 10)) / i;
            list.add(digit);
        }

        boolean isPalindrome = true;
        for (int i = 0; i < list.size() / 2; i++) {
            int digitA = list.get(i);
            int digitB = list.get(list.size() - 1 - i);
            if (digitA != digitB) {
                isPalindrome = false;
                break;
            }
        }

        log.info("Is " + n + " palindrome? " + isPalindrome);
    }

}
