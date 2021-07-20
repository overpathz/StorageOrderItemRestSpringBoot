package com.pathz.boot.rest.util;

import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.service.ItemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillPrimaryData {

    @Autowired
    private ItemServiceInterface itemServiceInterface;

    @PostConstruct
    public void execute() {
        itemServiceInterface.deleteAll();

        Item laptop = new Item();
        laptop.setName("Asus");
        laptop.setPrice(12500);
        laptop.setQuantity(6);

        Item smartphone = new Item();
        smartphone.setName("Xiaomi");
        smartphone.setPrice(6500);
        smartphone.setQuantity(8);

        Item microwave = new Item();
        microwave.setName("LG");
        microwave.setPrice(4750);
        microwave.setQuantity(4);

        List<Item> itemList = new ArrayList<>(List.of(laptop, smartphone, microwave));
        itemList.forEach(itemServiceInterface::save);
    }
}
