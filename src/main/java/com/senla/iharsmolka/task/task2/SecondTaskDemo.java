package com.senla.iharsmolka.task.task2;

import com.senla.iharsmolka.demo.TaskDemo;

public class SecondTaskDemo extends TaskDemo {

    private NumberFinder createFinder(String[] params){
        NumberFinder finder = null;
        try {
            int numb1 = Integer.parseInt(params[0]);
            int numb2 = Integer.parseInt(params[1]);
            finder = new NumberFinder(numb1, numb2);
        } catch (IllegalArgumentException exc) {
            showMessage("Input error: Seems like you've entered a negative number or an invalid character!", true);
        }
        return finder;
    }

    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Enter some numbers separated by spaces");
            String stringNumbers = getUserInput();
            if (stringNumbers.equals("")) {
                running = false;
                continue;
            }
            String[] params = parseBySpaces(stringNumbers);
            if (params.length != 2) {
                showMessage("Input error: There are some extra or missing arguments!", true);
                continue;
            }
            NumberFinder finder = createFinder(params);
            if (finder==null){
                continue;
            }
            int gcd = finder.getGCD();
            int lcm = finder.getLCM();
            showMessage(String.format("GCD = %s, LCM = %s", gcd, lcm));
            showPause();
        }
    }
}
