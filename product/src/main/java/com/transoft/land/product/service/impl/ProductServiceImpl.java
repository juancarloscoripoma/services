package com.transoft.land.product.service.impl;

import com.transoft.land.product.domain.Product;
import com.transoft.land.product.repository.ProductRepository;
import com.transoft.land.product.service.ProductService;
import com.transoft.land.product.service.dto.ProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    //@Transactional(value = true)
    public List<ProductDTO> findAll() {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> find = productRepository.findAll();

        find.stream().forEach(product -> {
            result.add(new ProductDTO(product.getId(), product.getName(),product.getAmount(),product.getCreatedDate()));
        });
        return result;
    }

    @Override
    public Page<ProductDTO> findAllByPageable(Pageable pageable) {
        Page<Product> result = productRepository.findAllByPage(pageable);
        return result.map(product -> new ProductDTO(product.getId(), product.getName(), product.getAmount(), product.getCreatedDate()));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
