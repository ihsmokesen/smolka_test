package com.senla.iharsmolka.task3;

public class ModifiedString {
    private String text = "";
    private String[] words = new String[0];

    /*
     * Constructor.
     * @param string - this is the text for modification
     * */
    public ModifiedString(String string) {
        setText(string);
    }

    public String getText() {
        return text;
    }

    public String[] getWords() {
        return words;
    }

    public int getCountWords() {
        return words.length;
    }

    public void setText(String text) {
        this.text = text;
        initializeWords();
    }

    /*
     * Method for forming a list of words
     * Changes starts letters of a words to a uppercase analog
     * */
    private void initializeWords() {
        if (text.equals("")) {
            return;
        }
        String buf = text.replaceAll("\\s+", " ");
        buf = buf.replaceAll("^[ ]", "");
        words = buf.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                continue;
            }
            StringBuilder bufBuilder = new StringBuilder(words[i]);
            bufBuilder.setCharAt(0, Character.toTitleCase(bufBuilder.charAt(0)));
            words[i] = bufBuilder.toString();
        }
    }

    /*
     * Method for sorting a list of words
     * */
    public void sortArray() {
        if (words.length == 0) {
            return;
        }
        for (int i = 0; i < words.length - 1; i++) {
            boolean f = false;
            for (int j = 0; j < words.length - i - 1; j++) {
                if ((int)words[j+1].charAt(0) < (int)words[j].charAt(0)) {
                    f = true;
                    String buf = words[j+1];
                    words[j+1] = words[j];
                    words[j] = buf;
                }
            }
            if (!f) {
                break;
            }
        }
    }

}
