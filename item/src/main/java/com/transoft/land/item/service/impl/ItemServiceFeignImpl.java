package com.transoft.land.item.service.impl;

import com.transoft.land.item.domain.Item;
import com.transoft.land.item.rest.controller.external.ProductClientControl;
import com.transoft.land.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeignImpl")
@Primary
public class ItemServiceFeignImpl implements ItemService {

    @Autowired
    private ProductClientControl productClientFeign;

    @Override
    public List<Item> findAll() {
        return productClientFeign.findAll().stream().map(productDTO -> new Item(productDTO,1)).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllObj() {
        return productClientFeign.findAll().stream().map(product -> new Item(product,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productClientFeign.findById(id), quantity);
    }
}
