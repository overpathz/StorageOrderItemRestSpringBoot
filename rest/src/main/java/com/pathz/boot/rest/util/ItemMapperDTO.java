package com.pathz.boot.rest.util;

import com.pathz.boot.rest.dto.ItemRequestDTO;
import com.pathz.boot.rest.dto.ItemResponseDTO;
import com.pathz.boot.rest.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapperDTO {

    public Item mapDTOtoItem(ItemRequestDTO itemRequestDTO) {
        Item item = new Item();

        item.setName(itemRequestDTO.getName());
        item.setPrice(itemRequestDTO.getPrice());
        item.setQuantity(itemRequestDTO.getQuantity());

        return item;
    }

    public ItemResponseDTO mapItemToDTO(Item item) {
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();

        itemResponseDTO.setId(item.getId());
        itemResponseDTO.setName(item.getName());
        itemResponseDTO.setPrice(item.getPrice());
        itemResponseDTO.setQuantity(item.getQuantity());

        return itemResponseDTO;
    }
}
