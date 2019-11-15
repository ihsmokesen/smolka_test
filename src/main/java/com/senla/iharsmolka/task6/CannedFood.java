package com.senla.iharsmolka.task6;

public class CannedFood extends Item {

    private String name = "";

    public CannedFood(String name, int weight, int cost) {
        super(weight, cost);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Консерва \""+name + "\" "+this.getWeight().toString()+" кг. " + this.getCost().toString()+"р.";
    }
}