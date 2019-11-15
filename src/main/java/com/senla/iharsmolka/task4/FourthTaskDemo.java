package com.senla.iharsmolka.task4;

import com.senla.iharsmolka.TaskDemo;

public class FourthTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Введите строку");
            String str = getUserInput();
            if (str.equals("")) {
                running = false;
                continue;
            }
            showMessage("Введите искомое слово");
            String word = getUserInput();
            StringFinder finder = new StringFinder(str);
            finder.setDesiredWord(word);
            showMessage(String.format("Слово %s встречается %s раз", word, finder.countOfEntries()));
            showPause();
        }
    }
}
