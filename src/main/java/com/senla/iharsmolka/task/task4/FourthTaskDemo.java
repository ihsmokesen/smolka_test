package com.senla.iharsmolka.task.task4;

import com.senla.iharsmolka.demo.TaskDemo;

public class FourthTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Type some text: ");
            String str = getUserInput();
            if (str.equals("")) {
                running = false;
                continue;
            }
            showMessage("What word you are looking for? :");
            String word = getUserInput();
            StringFinder finder = new StringFinder(str);
            finder.setDesiredWord(word);
            showMessage(String.format("Given word %s occurs %s times", word, finder.countOfEntries()));
            showPause();
        }
    }
}
