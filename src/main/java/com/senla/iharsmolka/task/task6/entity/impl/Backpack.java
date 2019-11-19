package com.senla.iharsmolka.task.task6.entity.impl;

import com.senla.iharsmolka.task.task6.packer.impl.DynamicProgrammingPacker;
import com.senla.iharsmolka.task.task6.entity.Item;
import com.senla.iharsmolka.task.task6.entity.iBackpack;
import com.senla.iharsmolka.task.task6.packer.iPacker;

import java.util.ArrayList;
import java.util.List;

public class Backpack implements iBackpack {

    private int currentWeight;
    private int capacity;
    private List<Item> items;

    /**
     * Constructor.
     * @param capacity - capacity of backpack
     */
    public Backpack(int capacity) {
        setCapacity(capacity);
        this.currentWeight = capacity;
        items = new ArrayList<>();
    }


    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * Capacity-setter
     * @param capacity - capacity of backpack
     * throw IllegalArgumentException if capacity is negative
     */
    @Override
    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be a negative!");
        }
        this.capacity = capacity;
    }

    /**
     * Method that returns the total cost of items in a backpack
     * @return total cost of items in a backpack
     */
    @Override
    public int getLoadedCost() {
        if (items == null || items.isEmpty()) {
            return 0;
        }
        int sumOfCost = 0;
        for (Item item : items) {
            sumOfCost += item.getCost();
        }
        return sumOfCost;
    }

    /**
     * Method that returns the amount of free space in the backpack
     * @return amount of free space in the backpack
     */
    @Override
    public int getFreeSpace() {
        return capacity - currentWeight;
    }

    public String getStringListItems() {
        if (items == null || items.isEmpty()) {
            return "";
        }
        StringBuilder list = new StringBuilder();
        for (Item item : items) {
            list.append(item.toString()).append("\n");
        }
        return list.toString();
    }

    /**
     * Method that puts an optimal set of items in a backpack
     * @param items - list of all items
     */
    @Override
    public void putInBackpack(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return;
        }
        iPacker packer = new DynamicProgrammingPacker();
        List<Item> optimalSetOfItems = packer.getSolution(items, currentWeight);
        if (optimalSetOfItems == null || optimalSetOfItems.isEmpty()) {
            return;
        }
        this.items.addAll(optimalSetOfItems);
        int sumWeight = 0;
        for (Item item : optimalSetOfItems) {
            sumWeight += item.getWeight();
        }
        currentWeight -= sumWeight;
    }


    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
