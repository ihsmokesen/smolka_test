package com.senla.iharsmolka.task.task5;

import com.senla.iharsmolka.demo.TaskDemo;

import java.util.List;

public class FifthTaskDemo extends TaskDemo {

    private List<Integer> getPalindromes(String userInput) {
        List<Integer> palindromes = null;
        try {
            int number = Integer.parseInt(userInput);
            PalindromeSequence sequence = new PalindromeSequence(number);
            palindromes = sequence.getListOfPalindromes();
        } catch (IllegalArgumentException exc) {
            showMessage("Input doesn't meet the requirements!", true);
        }
        return palindromes;
    }

    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Enter a positive integer not exceeding 100");
            String stringNumber = getUserInput();
            if (stringNumber.equals("")) {
                running = false;
                continue;
            }
            List<Integer> palindromes = getPalindromes(stringNumber);
            if (palindromes==null){
                continue;
            }
            StringBuilder status = new StringBuilder();
            for (Integer num : palindromes) {
                status.append(num.toString()).append(" ");
            }
            showMessage(String.format("Palindromes are:\n%s", status.toString()));
            showPause();
        }
    }
}
