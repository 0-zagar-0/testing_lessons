package com.example.repository;

import com.example.model.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("FROM Product p WHERE p.price between ?1 AND ?2")
    List<Product> findAllByPriceBetween(
            BigDecimal fromPrice,
            BigDecimal toPrice,
            Pageable pageable);
}
