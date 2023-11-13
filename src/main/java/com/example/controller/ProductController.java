package com.example.controller;

import com.example.dto.product.ProductRequestDto;
import com.example.dto.product.ProductResponseDto;
import com.example.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProductResponseDto save(@RequestBody ProductRequestDto request) {
        return productService.save(request);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ProductResponseDto> getAll() {
        return productService.getAll();
    }
}
