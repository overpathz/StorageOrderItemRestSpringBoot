package com.pathz.boot.rest.controller;

import com.pathz.boot.rest.dto.ItemRequestDTO;
import com.pathz.boot.rest.dto.ItemResponseDTO;
import com.pathz.boot.rest.dto.OrderResponseDTO;
import com.pathz.boot.rest.service.ItemServiceInterface;
import com.pathz.boot.rest.util.ItemMapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemServiceInterface itemService;

    @Autowired
    private ItemMapperDTO itemMapperDTO;

    @GetMapping
    public List<ItemResponseDTO> buyItem(@RequestParam String name,
                                         @RequestParam Integer quantity) {

        List<ItemResponseDTO> items = itemService
                .getCheapestItems(name, quantity)
                .stream()
                .map(item->itemMapperDTO.mapItemToDTO(item))
                .collect(Collectors.toList());

        return items;
    }

    @PostMapping
    public void addItem(@RequestBody ItemRequestDTO itemRequestDto) {
        itemService.save(itemMapperDTO.mapDTOtoItem(itemRequestDto));
    }
}
