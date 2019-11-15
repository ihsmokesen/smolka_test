package com.senla.iharsmolka.task3;

import com.senla.iharsmolka.TaskDemo;
import com.senla.iharsmolka.task2.NumberSearcher;

public class ThirdTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Вводите строку");
            String str = getUserInput();
            if (str.equals("")) {
                running = false;
                continue;
            }
            ModifiedString modifiedString = new ModifiedString(str);
            StringBuilder status = new StringBuilder("");
            status.append("Количество слов: ").append(modifiedString.getCountWords()).append(" \n");
            modifiedString.sortArray();
            String[] words = modifiedString.getWords();
            for (String word: words) {
                status.append(word).append("\n");
            }
            showMessage(status.toString());
            showPause();
        }
    }
}
