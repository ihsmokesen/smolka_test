package com.senla.iharsmolka.task1;

public class NumberInfo {

    private int n = 0;

    /*
    * Constructor.
    * @param n - this is the number to be analyzed
    * constructor throws an IllegalArgumentException if the number N is negative
    * */
    public NumberInfo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be a negative!");
        }
        this.n = n;
    }

    /*
    * Method for determining a simple number or not
    * @returns true - if number is simple, false - if number is not simple
    * */
    public boolean isSimple() {
        if (n <= 1) {
            return false;
        }
        int i = 2;
        while (i*i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }


    /*
     * Method for determining a composite number or not
     * @returns true - if number is composite, false - if number is not composite
     * */
    public boolean isComposite() {
        return !isSimple();
    }


    /*
     * Method for determining a even number or not
     * @returns true - if number is even, false - if number is not even
     * */
    public boolean isEven() {
        return n % 2 == 0;
    }

    /*
     * Method for determining a not-even number or not
     * @returns true - if number is not-even, false - if number is even
     * */
    public boolean isNotEven() {
        return !isEven();
    }

}

