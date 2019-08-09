package com.transoft.land.item.service.impl;

import com.transoft.land.item.domain.Item;
import com.transoft.land.item.domain.Product;
import com.transoft.land.item.service.ItemService;
import com.transoft.land.item.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        List<ProductDTO> products = Arrays.asList( clientRest.getForObject("http://localhost:8001/api/report/find-all/list", ProductDTO[].class) );
        return products.stream().map(productDTO -> new Item(productDTO,1)).collect(Collectors.toList());
    }

    @Override
    public List<Item> findAllObj() {
        List<Product> products = Arrays.asList( clientRest.getForObject("http://localhost:8001/api/report/find-all/list/obj", Product[].class) );
        return products.stream().map(product -> new Item(product,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariable = new HashMap<>();
        pathVariable.put("id", id.toString());

        Product product = clientRest.getForObject("http://localhost:8001/api/product/find-by/{id}", Product.class, pathVariable);
        return new Item(product, quantity);
    }
}
