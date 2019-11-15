package com.senla.iharsmolka.task1;

import com.senla.iharsmolka.TaskDemo;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class FirstTaskDemo extends TaskDemo {

    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Введите число");
            Integer numb = null;
            try {
                String userInput = getUserInput();
                if (userInput.equals("")) {
                    running = false;
                    continue;
                }
                numb = Integer.parseInt(userInput);
            }
            catch (IllegalArgumentException exc) {
                showMessage("Число введено некорректно, повторите попытку!", true);
                continue;
            }
            NumberInfo numberInfo = new NumberInfo(numb);
            StringBuilder info = new StringBuilder();
            if (numberInfo.isSimple()) {
                info.append("Число простое\n");
            } else {
                if (numberInfo.isComposite()) {
                    info.append("Число составное\n");
                }
            }
            if (numberInfo.isEven()) {
                info.append("Число четное\n");
            } else {
                if (numberInfo.isNotEven()) {
                    info.append("Число нечетное\n");
                }
            }
            showMessage(info.toString());
            showPause();
        }


    }
}
