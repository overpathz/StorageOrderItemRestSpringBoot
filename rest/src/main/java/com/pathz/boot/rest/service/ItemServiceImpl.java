package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.exception.ItemNotFoundException;
import com.pathz.boot.rest.logging.ItemLogger;
import com.pathz.boot.rest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ItemServiceImpl implements ItemServiceInterface {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemLogger itemLogger;

    private final Logger logger = Logger.getLogger("ItemServiceLogger");

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

        if (quantity > cheapestItemQuantity) {
            logger.log(Level.INFO, itemLogger.getLoggerMessages().get("cheapestItemsGetFail"));
            return itemRepository.findAll();
        } else {
            for (int i = 0; i < quantity; i++) {
                returnedItems.add(new Item(foundedCheapestItem));
                Item item = new Item(foundedCheapestItem);
                item.setQuantity(--cheapestItemQuantity);
                itemRepository.save(item);
            }
        }

        logger.log(Level.INFO, itemLogger.getLoggerMessages().get("cheapestItemsGetSuccess"));
        return returnedItems;
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
