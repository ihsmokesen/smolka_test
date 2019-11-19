package com.senla.iharsmolka.task.task4;

class StringFinder {

    private String text;
    private String desiredWord = "";

    /**
     * Constructor.
     * @param string - this is the text for searching
     */
    StringFinder(String string) {
        text = string;
    }

    private String[] splitText(){
        String buf = text.replaceAll("\\s+", " ");
        buf = buf.replaceAll("[,.;!?:]", "").replaceAll("^[ ]", "");
        return buf.split("\\s");
    }

    /**
     * Method for finding the number of occurrences of a word
     * @return number of occurrences of a word
     * Not case sensitive
     */
    int countOfEntries() {
        if (desiredWord.equals("") || text.equals("")) {
            return 0;
        }
        String[] words = splitText();
        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().equals(desiredWord.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    String getText() {
        return text;
    }

    String getDesiredWord() {
        return desiredWord;
    }

    void setDesiredWord(String word) {
        desiredWord = word;
    }

    public void setText(String text) {
        this.text = text;
    }
}
