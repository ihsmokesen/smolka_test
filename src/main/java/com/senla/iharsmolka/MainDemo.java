package com.senla.iharsmolka;

import com.senla.iharsmolka.task1.FirstTaskDemo;
import com.senla.iharsmolka.task2.SecondTaskDemo;
import com.senla.iharsmolka.task3.ThirdTaskDemo;
import com.senla.iharsmolka.task4.FourthTaskDemo;
import com.senla.iharsmolka.task5.FiveTaskDemo;
import com.senla.iharsmolka.task6.SixTaskDemo;

public class MainDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Выберите задачу для демонстрации:1-6");
            String stringNum = getUserInput();
            Integer num = null;
            if (stringNum.equals("")) {
                running = false;
                continue;
            }
            try {
                num = Integer.parseInt(stringNum);
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
                        (new FiveTaskDemo()).startDemo();
                        break;
                    }
                    case 6: {
                        (new SixTaskDemo()).startDemo();
                        break;
                    }
                    default:
                        throw new IllegalArgumentException("Mark is out of range!");
                }
            }
            catch (IllegalArgumentException exc) {
                showMessage("Пункт введен некорректно! Повторите попытку",true);
                continue;
            }
//            showPause();
        }
    }
}
