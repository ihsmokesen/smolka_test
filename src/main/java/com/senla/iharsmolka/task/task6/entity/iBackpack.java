package com.senla.iharsmolka.task.task6.entity;

import java.util.List;

public interface iBackpack {
    int getCapacity();

    void setCapacity(int capacity);

    int getFreeSpace();

    int getLoadedCost();

    void putInBackpack(List<Item> items);

}
