package com.senla.iharsmolka.task.task5;

import java.util.ArrayList;
import java.util.List;

class PalindromeSequence extends IntSequence {

    PalindromeSequence(int endOFSequence) {
        super(endOFSequence);
    }

    /**
     * Method determines whether a number is a palindrome
     *
     * @param numb - number for analysis
     * @return true if number is palindrome
     */
    private boolean isPalindrome(Integer numb) {
        if (numb >= 0 && numb <= 9) {
            return true;
        }
        String reverseStringNumber = (new StringBuilder(numb.toString()).reverse()).toString();
        int parsingReverseNumber;
        try {
            parsingReverseNumber = Integer.parseInt(reverseStringNumber);
        } catch (Exception exc) {
            return false;
        }
        return numb.equals(parsingReverseNumber);
    }

    /**
     * Method returns ArrayList of palindromes
     */
    List<Integer> getListOfPalindromes() {
        if (N == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int num = 0; num <= N; num++) {
            if (isPalindrome(num)) {
                result.add(num);
            }
        }
        return result;
    }
}