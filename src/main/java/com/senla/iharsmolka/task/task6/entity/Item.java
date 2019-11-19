package com.senla.iharsmolka.task.task6.entity;

public abstract class Item {

    protected Integer weight;
    protected Integer cost;

    public Item(int weight, int cost) {
        if (weight <= 0 || cost < 0) {
            throw new IllegalArgumentException("Item cannot have negative weight or cost!");
        }
        this.weight = weight;
        this.cost = cost;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.getWeight().toString() + " kilos. " + this.getCost().toString() + "rub.";
    }

}