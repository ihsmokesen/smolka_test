package com.senla.iharsmolka.demo;

import com.senla.iharsmolka.task.task1.FirstTaskDemo;
import com.senla.iharsmolka.task.task2.SecondTaskDemo;
import com.senla.iharsmolka.task.task3.ThirdTaskDemo;
import com.senla.iharsmolka.task.task4.FourthTaskDemo;
import com.senla.iharsmolka.task.task5.FifthTaskDemo;
import com.senla.iharsmolka.task.task6.SixthTaskDemo;

public class MainDemo extends TaskDemo {

    private void taskSelection(String stringNum){
        try {
            int num = Integer.parseInt(stringNum);
            switch (num) {
                case 1: {
                    (new FirstTaskDemo()).startDemo();
                    break;
                }
                case 2: {
                    (new SecondTaskDemo()).startDemo();
                    break;
                }
                case 3: {
                    (new ThirdTaskDemo()).startDemo();
                    break;
                }
                case 4: {
                    (new FourthTaskDemo()).startDemo();
                    break;
                }
                case 5: {
                    (new FifthTaskDemo()).startDemo();
                    break;
                }
                case 6: {
                    (new SixthTaskDemo()).startDemo();
                    break;
                }
                default:
                    throw new IllegalArgumentException("Mark is out of range!");
            }
        } catch (IllegalArgumentException exc) {
            showMessage("Wrong input! Try again", true);
        }
    }
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Select a task to demonstrate: 1-6");
            String stringNum = getUserInput();
            if (stringNum.equals("")) {
                running = false;
                continue;
            }
            taskSelection(stringNum);
        }
    }
}
