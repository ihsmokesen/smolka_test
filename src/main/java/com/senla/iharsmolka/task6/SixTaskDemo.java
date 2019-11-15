package com.senla.iharsmolka.task6;

import com.senla.iharsmolka.TaskDemo;

import java.util.ArrayList;
import java.util.List;

public class SixTaskDemo extends TaskDemo {
    @Override
    public void startDemo() {
        boolean running = true;
        boolean inputItems = true;
        while (running) {
            inputItems = true;
            showMessage("Введите вместимость рюкзака");
            String stringCapacity = getUserInput();
            if (stringCapacity.equals("")) {
                running = false;
                continue;
            }
            Integer capacity = null;
            Backpack backpack = null;
            try {
                capacity = Integer.parseInt(stringCapacity);
                backpack = new Backpack(capacity);
            }
            catch (IllegalArgumentException exc) {
                showMessage("Введенное число некорректно!",true);
                continue;
            }
            List<Item> itemsList = new ArrayList<>();
            while (inputItems) {
                showMessage("Введите НАЗВАНИЕ, ВЕС и СТОИМОСТЬ консервы (через пробел)");
                String cannedFoodStringParams = getUserInput();
                if (cannedFoodStringParams.equals("")) {
                    inputItems = false;
                    continue;
                }
                String[] params = parsingBySpaces(cannedFoodStringParams);
                try {
                    if (params.length != 3) {
                        throw new IllegalArgumentException("Missing/redundant argument for item!");
                    }
                    String name = params[0];
                    Integer weight = Integer.parseInt(params[1]);
                    Integer cost = Integer.parseInt(params[2]);
                    itemsList.add(new CannedFood(name, weight, cost));
                }
                catch (IllegalArgumentException exc) {
                    showMessage("Введен некорректный параметр для консервы, либо присутствует лишний/недостающий параметр!",true);
                    continue;
                }
            }
            try {
                backpack.putInBackpack(itemsList);
            }
            catch (RuntimeException exc) {
                showMessage("Извините, во время расчета произощла ошибка!",true);
                continue;
            }
            StringBuilder status = new StringBuilder(backpack.getStringListItems());
            status.append("Места в рюкзаке осталось ").append(backpack.currentWeight).append("кг.\n");
            status.append("Стоимость предметов в рюкзаке ").append(backpack.getCostItems()).append("р.\n");
            showMessage(status.toString());
            showPause();
        }
    }
}
