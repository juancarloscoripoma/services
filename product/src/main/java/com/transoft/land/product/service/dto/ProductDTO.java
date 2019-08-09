package com.transoft.land.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDTO implements Serializable {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private Date createdDate;
}
