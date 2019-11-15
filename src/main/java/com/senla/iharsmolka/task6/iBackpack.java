package com.senla.iharsmolka.task6;

import java.util.List;

public interface iBackpack {
     int getCapacity();
     void setCapacity(int capacity);
     int getWeightItems();
     int getCostItems();
     void putInBackpack(List<Item> items);

}
