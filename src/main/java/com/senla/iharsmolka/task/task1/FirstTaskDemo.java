package com.senla.iharsmolka.task.task1;

import com.senla.iharsmolka.demo.TaskDemo;

public class FirstTaskDemo extends TaskDemo {

    private void appendResult(StringBuilder info, NumberInfo numberInfo) {
        if (numberInfo.isSimple()) {
            info.append("Number is prime\n");
        } else if (numberInfo.isComposite()) {
            info.append("Number is composite\n");
        }
        if (numberInfo.isEven()) {
            info.append("Number is even\n");
        } else if (numberInfo.isNotEven()) {
            info.append("Number is odd\n");
        }
    }

    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Enter a number: ");
            int numb;
            try {
                String stringNumber = getUserInput();
                if (stringNumber.equals("")) {
                    running = false;
                    continue;
                }
                numb = Integer.parseInt(stringNumber);
            } catch (IllegalArgumentException exc) {
                showMessage("Wrong input! Try again", true);
                continue;
            }
            NumberInfo numberInfo = new NumberInfo(numb);
            StringBuilder info = new StringBuilder();
            appendResult(info, numberInfo);
            showMessage(info.toString());
            showPause();
        }
    }

}
