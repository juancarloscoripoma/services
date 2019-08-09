package com.transoft.land.product.repository;

import com.transoft.land.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select distinct p from Product p ",
            countQuery = "select count(distinct p) from Product p ")
    Page<Product> findAllByPage(Pageable pageable);
}
