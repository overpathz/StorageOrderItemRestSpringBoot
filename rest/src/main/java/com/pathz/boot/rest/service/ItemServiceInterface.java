package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Item;

import java.util.List;

public interface ItemServiceInterface {
    Item save(Item item);
    Item findById(Long id);
    List<Item> getCheapestItems(String name, Integer quantity);
}
