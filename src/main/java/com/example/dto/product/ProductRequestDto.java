package com.example.dto.product;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String title;
    private BigDecimal price;
}
