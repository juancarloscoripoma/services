package com.transoft.land.item.rest.controller.external;

import com.transoft.land.item.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-products", url = "localhost:8001")
public interface ProductClientControl {

    @GetMapping("/report/find-all/list/obj")
    List<Product> findAll();

    @GetMapping("/product/find-by/{id}")
    Product findById(@PathVariable Long id);

}
