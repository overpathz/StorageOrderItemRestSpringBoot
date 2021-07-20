package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.exception.ItemNotFoundException;
import com.pathz.boot.rest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemServiceInterface {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Integer id) {
        String errorMessage = String.format("%s%d%s", "Item with id", id, " not found");
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage));
    }

    @Override
    public List<Item> getCheapestItems(String name, Integer quantity) {
        List<Item> items = itemRepository.findAllByNameOrderByPriceAsc(name);
        List<Item> returnedItems = new ArrayList<>();

        Item foundedCheapestItem = items.get(0);
        Integer cheapestItemQuantity = foundedCheapestItem.getQuantity();

        System.out.println(foundedCheapestItem);
        System.out.println(cheapestItemQuantity);

        if (quantity > cheapestItemQuantity) {
            System.out.println("Request quantity is bigger than item quantity");
            return items;
        } else {
            for (int i = 0; i < quantity; i++) {
                returnedItems.add(new Item(foundedCheapestItem));
                Item item = new Item(foundedCheapestItem);
                item.setQuantity(--cheapestItemQuantity);
                itemRepository.save(item);
            }
        }

        return returnedItems;
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
