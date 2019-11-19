package com.senla.iharsmolka.task.task6.packer.impl;

import com.senla.iharsmolka.task.task6.entity.Item;
import com.senla.iharsmolka.task.task6.packer.iPacker;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgrammingPacker implements iPacker {

    /**
     * A recursive method for restoring an optimal set of objects from a dynamics matrix
     * @param itemIndex - index of start line
     * @param capacityIndex - index of start column
     * @param dynamicMatrix - dynamics matrix
     * @result - array to fill with an optimal set of items
     * @items - array of items
     */
    private void restoreSolution(int itemIndex, int capacityIndex, int[][] dynamicMatrix,
                                 List<Item> result, List<Item> items) {
        if (items == null || items.isEmpty() || dynamicMatrix.length == 0 || dynamicMatrix[0].length == 0) {
            return;
        }
        if (dynamicMatrix[itemIndex][capacityIndex] == 0) {
            return;
        }
        if (dynamicMatrix[itemIndex - 1][capacityIndex] == dynamicMatrix[itemIndex][capacityIndex]) {
            restoreSolution(itemIndex - 1, capacityIndex, dynamicMatrix, result, items);
        } else {
            restoreSolution(itemIndex - 1, capacityIndex - items.get(itemIndex - 1).getWeight(),
                            dynamicMatrix, result, items);
            if (result == null) {
                result = new ArrayList<>();
            }
            result.add(items.get(itemIndex - 1));
        }
    }

    /**
     * Dynamic matrix creation method
     * @param items - array of items
     * @param capacity - capacity of backpack
     * @return dynamic matrix
     */
    private int[][] createDynamicMatrix(List<Item> items, int capacity) {
        if (items == null || items.isEmpty() || capacity == 0) {
            return new int[0][0];
        }
        int[][] dynamic = new int[items.size() + 1][capacity + 1];
        for (int i = 1; i <= items.size(); i++) {
            for (int j = 0; j <= capacity; j++) {
                dynamic[i][j] = dynamic[i - 1][j];
                if (j - items.get(i - 1).getWeight() >= 0) {
                    dynamic[i][j] = Math.max(dynamic[i][j],
                            dynamic[i - 1][j - items.get(i - 1).getWeight()] + items.get(i - 1).getCost());
                }
            }
        }
        return dynamic;
    }


    /**
     * Method for verifying the validity of the response
     * @param capacity - capacity of backpack
     * @param answer - estimated optimal set of items
     * @return true if answer is valid (summary weight of items in number not greatest than capacity of backpack)
     */
    private boolean answerIsValid(int capacity, List<Item> answer) {
        if (answer == null || answer.isEmpty()) {
            return true;
        }
        int sum = 0;
        for (Item item : answer) {
            sum += item.getWeight();
        }
        return sum <= capacity;
    }

    /**
     * Method for getting the optimal set of items
     * @param items - array of items
     * @param capacity - capacity of backpack
     * throw RuntimeException if answer is not valid
     */
    public List<Item> getSolution(List<Item> items, int capacity) {
        List<Item> result = new ArrayList<>();
        int[][] dynamic = createDynamicMatrix(items, capacity);
        restoreSolution(items.size(), capacity, dynamic, result, items);
        if (answerIsValid(capacity, result)) {
            return result;
        }
        throw new RuntimeException("Packer received an invalid answer!");
    }

}
