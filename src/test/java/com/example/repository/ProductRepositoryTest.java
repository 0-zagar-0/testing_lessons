package com.example.repository;

import com.example.model.Product;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("""
            Find all products by price when price is less than 100
            """)
    void findAllByPriceBetween_PriceLessThan100_ReturnsEmptyList() {
        Product book = new Product();
        book.setTitle("Book");
        book.setPrice(BigDecimal.valueOf(49.95));
        productRepository.save(book);

        List<Product> actual = productRepository.findAllByPriceBetween(
                BigDecimal.ZERO, BigDecimal.valueOf(100), PageRequest.of(0, 10)
        );

        Assertions.assertEquals(1, actual.size());
    }

}