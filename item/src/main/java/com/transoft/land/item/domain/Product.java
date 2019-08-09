package com.transoft.land.item.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private Long id;

    private String name;

    private BigDecimal amount;

    private Date createdDate;

}
