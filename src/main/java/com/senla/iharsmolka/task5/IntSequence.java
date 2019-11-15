package com.senla.iharsmolka.task5;

public class IntSequence {

    protected static final int LIMIT = 100;
    protected int N = 0;

    /*
     * Constructor.
     * @param endOfSequence - this is upper bound of the sequence
     * */
    public IntSequence(int endOFSequence) {
        setEndSequence(endOFSequence);
    }

    public int getEndOfSequence() {
        return N;
    }

    public static int getLimit() {
        return LIMIT;
    }

    /*
     * Upper bound of the sequence setter
     * throws IllegalArgumentException if the upper bound of the sequence is negative or greater than the limit
     * */
    public void setEndSequence(int endOFSequence) {
        if (endOFSequence < 0) {
            throw new IllegalArgumentException("End of sequence cannot be negative!");
        }
        if (endOFSequence > LIMIT) {
            throw new IllegalArgumentException("End of sequence cannot be more than limit!");
        }
        N = endOFSequence;
    }

}
