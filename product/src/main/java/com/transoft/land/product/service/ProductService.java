package com.transoft.land.product.service;

import com.transoft.land.product.domain.Product;
import com.transoft.land.product.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    Page<ProductDTO> findAllByPageable(Pageable pageable);
    Product findById(Long id);
}
