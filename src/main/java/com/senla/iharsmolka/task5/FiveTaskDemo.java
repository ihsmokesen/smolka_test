package com.senla.iharsmolka.task5;

import com.senla.iharsmolka.TaskDemo;
import com.senla.iharsmolka.task4.StringFinder;

import java.util.List;

public class FiveTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Введите положительное целое число, не превышающее 100");
            String userInput = getUserInput();
            Integer number = null;
            if (userInput.equals("")) {
                running = false;
                continue;
            }
            List<Integer> palindromes = null;
            try {
                number = Integer.parseInt(userInput);
                PalindromeSequence sequence = new PalindromeSequence(number);
                palindromes = sequence.getListOfPalindromes();
            }
            catch (IllegalArgumentException exc) {
                showMessage("Число не соответствует требованиям!",true);
                continue;
            }
            StringBuilder status = new StringBuilder("");
            for (Integer num : palindromes) {
                status.append(num.toString()).append(" ");
            }
            showMessage(String.format("Палиндромы:\n%s", status.toString()));
            showPause();
        }
    }
}
