package com.senla.iharsmolka.task2;

import com.senla.iharsmolka.TaskDemo;
import com.senla.iharsmolka.task1.NumberInfo;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class SecondTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            Integer numb1 = null;
            Integer numb2 = null;
            NumberSearcher searcher = null;
            showMessage("Введите числа разделяя их пробелом(ами). ");
            String userInput = getUserInput();
            if (userInput.equals("")) {
                running = false;
                continue;
            }
            String[] params = parsingBySpaces(userInput);
            if (params.length != 2) {
                showMessage("Ошибка ввода: лишний или недостающий аргумент!",true);
                continue;
            }
            try {
                numb1 = Integer.parseInt(params[0]);
                numb2 = Integer.parseInt(params[1]);
                searcher = new NumberSearcher(numb1, numb2);
            }
            catch (IllegalArgumentException exc) {
                showMessage("Ошибка ввода: возможно, вы ввели отрицательное число, либо недопустимый символ!",true);
                continue;
            }
            int gcd = searcher.getGCD();
            int lcm = searcher.getLCM();
            showMessage(String.format("НОД = %s, НОК = %s", gcd, lcm));
            showPause();
        }
    }
}
