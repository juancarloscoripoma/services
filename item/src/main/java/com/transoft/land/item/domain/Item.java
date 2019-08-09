package com.transoft.land.item.domain;

import com.transoft.land.item.service.dto.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Item {

    private ProductDTO productDTO;

    private Product product;

    private Integer quantity;

    public Item(ProductDTO productDTO, Integer quantity) {
        this.productDTO = productDTO;
        this.quantity = quantity;
    }

    public Item(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getTotal(){
        if(null != product)
            return product.getAmount().multiply( new BigDecimal(quantity) );
        else
            return null;
    }

    public BigDecimal getTotalDto(){
        if(null != productDTO)
            return productDTO.getAmount().multiply( new BigDecimal(quantity) );
        else
            return null;
    }
}
