package com.senla.iharsmolka.task.task6;

import com.senla.iharsmolka.demo.TaskDemo;
import com.senla.iharsmolka.task.task6.entity.impl.Backpack;
import com.senla.iharsmolka.task.task6.entity.impl.CannedFood;
import com.senla.iharsmolka.task.task6.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class SixthTaskDemo extends TaskDemo {

    private void runInputItemsCycle(List<Item> itemsList) {
        while (true) {
            showMessage("Enter TITLE, WEIGHT and COST of canned food (separated by space)");
            String cannedFoodStringParams = getUserInput();
            if (cannedFoodStringParams.equals("")) {
                break;
            }
            String[] params = parseBySpaces(cannedFoodStringParams);
            try {
                if (params.length != 3) {
                    throw new IllegalArgumentException("Missing/redundant argument for item!");
                }
                String name = params[0];
                int weight = Integer.parseInt(params[1]);
                int cost = Integer.parseInt(params[2]);
                itemsList.add(new CannedFood(name, weight, cost));
            } catch (IllegalArgumentException exc) {
                showMessage("You've entered an incorrect parameter or there are " +
                        "some extra/missing parameters!", true);
            }
        }
    }

    @Override
    public void startDemo() {
        boolean running = true;
        while (running) {
            showMessage("Enter backpack capacity");
            String stringCapacity = getUserInput();
            if (stringCapacity.equals("")) {
                running = false;
                continue;
            }
            int capacity;
            Backpack backpack;
            try {
                capacity = Integer.parseInt(stringCapacity);
                backpack = new Backpack(capacity);
            } catch (IllegalArgumentException exc) {
                showMessage("Input is incorrect!", true);
                continue;
            }
            List<Item> itemsList = new ArrayList<>();
//            while (inputItemsRunning) {
//                showMessage("Enter TITLE, WEIGHT and COST of canned food (separated by space)");
//                String cannedFoodStringParams = getUserInput();
//                if (cannedFoodStringParams.equals("")) {
//                    inputItemsRunning = false;
//                    continue;
//                }
//                String[] params = parseBySpaces(cannedFoodStringParams);
//                try {
//                    if (params.length != 3) {
//                        throw new IllegalArgumentException("Missing/redundant argument for item!");
//                    }
//                    String name = params[0];
//                    int weight = Integer.parseInt(params[1]);
//                    int cost = Integer.parseInt(params[2]);
//                    itemsList.add(new CannedFood(name, weight, cost));
//                } catch (IllegalArgumentException exc) {
//                    showMessage("You've entered an incorrect parameter or there are " +
//                                        "some extra/missing parameters!", true);
//                }
//            }
            runInputItemsCycle(itemsList);
            try {
                backpack.putInBackpack(itemsList);
            } catch (RuntimeException exc) {
                showMessage("An error occurred during the calculation!", true);
                continue;
            }
            String status = backpack.getStringListItems() + "Space left in the backpack: " +
                            backpack.getCurrentWeight() + "kilos.\n" +
                    "Total items cost: " + backpack.getLoadedCost() + "rub.\n";
            showMessage(status);
            showPause();
        }
    }
}
