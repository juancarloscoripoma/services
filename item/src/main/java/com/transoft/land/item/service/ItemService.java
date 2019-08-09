package com.transoft.land.item.service;

import com.transoft.land.item.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    List<Item> findAllObj();
    Item findById(Long id, Integer quantity);
}
