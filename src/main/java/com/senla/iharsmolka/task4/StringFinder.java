package com.senla.iharsmolka.task4;

public class StringFinder {

    private String text = "";
    private String desiredWord = "";

    /*
     * Constructor.
     * @param string - this is the text for searching
     * */
    public StringFinder(String string) {
        text = string;
    }

    public String getText() {
        return text;
    }

    public String getDesiredWord() {
        return desiredWord;
    }

    public void setDesiredWord(String word) {
        desiredWord = word;
    }


    /*
     * Method for finding the number of occurrences of a word
     * @return number of occurrences of a word
     * Not case sensitive
     * */
    public int countOfEntries() {
        if (desiredWord.equals("") || text.equals("")) {
            return 0;
        }
        String buf = text.replaceAll("\\s+", " ");
        buf = buf.replaceAll("[,.;!?:]", "");
        buf = buf.replaceAll("^[ ]", "");
        String[] words = buf.split("\\s");
        int count = 0;
        for (String word : words) {

            if (word.toLowerCase().equals(desiredWord.toLowerCase())) {
                count++;
            }
        }
        return count;
    }


}
