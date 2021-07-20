package com.pathz.boot.rest.controller;

import com.pathz.boot.rest.service.ItemServiceInterface;
import com.pathz.boot.rest.util.ItemMapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemServiceInterface itemService;

    @Autowired
    private ItemMapperDTO itemMapperDTO;


}
