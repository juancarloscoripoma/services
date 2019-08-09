package com.transoft.land.product.web.rest;

import com.transoft.land.product.domain.Product;
import com.transoft.land.product.service.ProductService;
import com.transoft.land.product.service.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
public class ProductResource {

    private final Logger log = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/report/find-all/list")
    public ResponseEntity<List<ProductDTO>> findAllList() {
        List<ProductDTO> page = productService.findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/report/find-all/list/obj")
    public ResponseEntity<List<Product>> findAllListObj() {
        List<Product> page = productService.findAllObj();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/report/find-all/pageable")
    public ResponseEntity<List<ProductDTO>> findAllByPageable(@PageableDefault Pageable pageable) {
        Page<ProductDTO> page = productService.findAllByPageable(pageable);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page.getContent(), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/product/find-by/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product page = productService.findById(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(page, responseHeaders, HttpStatus.OK);
    }
}
