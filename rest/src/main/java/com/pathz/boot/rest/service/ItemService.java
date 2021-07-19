package com.pathz.boot.rest.service;

import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.exception.ItemNotFoundException;
import com.pathz.boot.rest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item addItem(Item order) {
        return itemRepository.save(order);
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        Optional<Item> optionalOrder = itemRepository.findById(id);
        String errorMessage = String.format("%s%d%s", "Item with id", id, " not found");
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(errorMessage));
    }
}
