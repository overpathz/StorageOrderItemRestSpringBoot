package com.pathz.boot.rest.repository;

import com.pathz.boot.rest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);
    List<Item> findAllByNameOrderByPriceAsc(String name);
}
