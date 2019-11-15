package com.senla.iharsmolka.task2;

public class NumberSearcher {

    private int num1;
    private int num2;

    /*
     * Constructor.
     * @param firstNumber - this is the first number for searcher
     * @param secondNumber - this is the second number for searcher
     * constructor throws an IllegalArgumentException if the first or second number is negative
     * */
    public NumberSearcher(int firstNumber, int secondNumber) {
        if (firstNumber < 0 || secondNumber < 0) {
            throw new IllegalArgumentException("Number cannot be a negative!");
        }
        num1 = Math.max(firstNumber, secondNumber);
        num2 = Math.min(firstNumber, secondNumber);
    }

    /*
     * GCD-getter
     * @returns 1 - if number1 equals number2
     * */
    public int getGCD() {
        if (num1 == num2) {
            return 1;
        }
        return gcdSearchStep(num1, num2);
    }

    /*
     * LCM-getter
     * */
    public int getLCM() {
        int gcd = getGCD();
        if (gcd == 0) {
            return 0;
        }
        return (num1 * num2) / gcd;
    }

    /*
     * A recursive function to find the GCD.
     * @param num1 - first number to search
     * @param num1 - second number to search
     * */
    private int gcdSearchStep(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        int remainder = num1 % num2;
        num1 = num2;
        num2 = remainder;
        return gcdSearchStep(num1, num2);
    }

}
