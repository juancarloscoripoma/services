package com.transoft.land.item.service.impl;

import com.transoft.land.item.domain.Item;
import com.transoft.land.item.rest.controller.external.ProductClientControl;
import com.transoft.land.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeignImpl")
@Primary
public class ItemServiceFeignImpl implements ItemService {

    private final Logger log = LoggerFactory.getLogger(ItemServiceFeignImpl.class);

    @Autowired
    private ProductClientControl productClientFeign;

    @Override
    public List<Item> findAll() {
        return null;
        //return productClientFeign.findAllObj().stream().map(productDTO -> new Item(productDTO,1)).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllObj() {
        log.debug("REST request to findAllObj");
        return productClientFeign.findAllObj().stream().map(product -> new Item(product,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productClientFeign.findById(id), quantity);
    }
}
