package com.senla.iharsmolka.task.task6.packer;

import com.senla.iharsmolka.task.task6.entity.Item;

import java.util.List;

public interface iPacker {

    List<Item> getSolution(List<Item> items, int capacity);

}
