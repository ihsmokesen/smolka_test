package com.senla.iharsmolka.task.task3;

import com.senla.iharsmolka.demo.TaskDemo;

public class ThirdTaskDemo extends TaskDemo {
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
            ModifiedString modifiedString = new ModifiedString(str);
            StringBuilder status = new StringBuilder("");
            status.append("Word count: ").append(modifiedString.getCountWords()).append(" \n");
            modifiedString.sortArray();
            String[] words = modifiedString.getWords();
            for (String word : words) {
                status.append(word).append("\n");
            }
            showMessage(status.toString());
            showPause();
        }
    }
}
