package com.transoft.land.item.rest.controller;

import com.transoft.land.item.domain.Item;
import com.transoft.land.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemResource {
    /*
    /api/report/item/find-all/list
    /api/item/find-all/list/obj
    /api/item/find-by/id/2/quantity/2
    */

    @Autowired
    private ItemService itemService;

    @GetMapping("/report/item/find-all/list")
    public ResponseEntity<List<Item>> findAllList() {
        List<Item> page = itemService.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/item/find-all/list/obj")
    public List<Item> findItemAllList() {
        List<Item> page = itemService.findAllObj();
        return page;
    }

    @GetMapping("/item/find-by/productId/{id}/quantity/{quantity}")
    public ResponseEntity<Item> findById(@PathVariable Long id, @PathVariable Integer quantity) {
        Item page = itemService.findById(id, quantity);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page, responseHeaders, HttpStatus.OK);
    }
}
