package com.pathz.boot.rest.service_layer;

import com.pathz.boot.rest.entity.Item;
import com.pathz.boot.rest.repository.ItemRepository;
import com.pathz.boot.rest.service.ItemServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @InjectMocks
    private ItemServiceImpl itemService;

    @Mock
    private ItemRepository itemRepository;

    private Item laptop;

    @BeforeEach
    public void init() {
        laptop = new Item(1, "Asus", 455, 2);
    }

    @Test
    void save() {
        itemService.save(laptop);
        verify(itemRepository, times(1)).save(laptop);
    }

    @Test
    void findById() {
        when(itemRepository.findById(1)).thenReturn(Optional.ofNullable(laptop));

        Item assertingItem = itemService.findById(1);
        Assertions.assertEquals(laptop, assertingItem);
    }
}
