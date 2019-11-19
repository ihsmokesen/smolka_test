package com.senla.iharsmolka.task.task5;

public class IntSequence {

    private static final int LIMIT = 100;
    int N = 0;

    /**
     * Constructor.
     * @param endOfSequence - this is upper bound of the sequence
     */
    IntSequence(int endOfSequence) {
        setEndSequence(endOfSequence);
    }

    /**
     * Upper bound of the sequence setter
     * throws IllegalArgumentException if the upper bound of the sequence is negative or greater than the limit
     */
    private void setEndSequence(int endOFSequence) {
        if (endOFSequence < 0) {
            throw new IllegalArgumentException("End of sequence cannot be negative!");
        }
        if (endOFSequence > LIMIT) {
            throw new IllegalArgumentException("End of sequence cannot be more than limit!");
        }
        N = endOFSequence;
    }

    public int getEndOfSequence() {
        return N;
    }

    public static int getLimit() {
        return LIMIT;
    }

}
