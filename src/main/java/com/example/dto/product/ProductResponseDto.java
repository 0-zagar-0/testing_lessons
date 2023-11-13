package com.example.dto.product;

import java.math.BigDecimal;

public record ProductResponseDto(Long id, String title, BigDecimal price) {
}
