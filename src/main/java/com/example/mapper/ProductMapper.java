package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.product.ProductRequestDto;
import com.example.dto.product.ProductResponseDto;
import com.example.model.Product;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ProductMapper {
    ProductResponseDto toDto(Product product);

    Product toEntity(ProductRequestDto request);
}
