package com.example.service.product;

import com.example.dto.product.ProductRequestDto;
import com.example.dto.product.ProductResponseDto;
import java.util.List;

public interface ProductService {
    ProductResponseDto save(ProductRequestDto request);

    List<ProductResponseDto> getAll();
}
