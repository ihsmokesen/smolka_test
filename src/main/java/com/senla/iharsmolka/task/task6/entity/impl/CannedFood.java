package com.senla.iharsmolka.task.task6.entity.impl;

import com.senla.iharsmolka.task.task6.entity.Item;

public class CannedFood extends Item {

    private String name;

    public CannedFood(String name, int weight, int cost) {
        super(weight, cost);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Консерва \"" + name + "\" " + this.getWeight().toString() + " кг. " + this.getCost().toString() + "р.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}