package com.caiopfaltzgraff.lecaru.repository;

import com.caiopfaltzgraff.lecaru.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = """
        SELECT p FROM Product p
        WHERE p.category.id NOT IN (
            SELECT c.id FROM Category c
            WHERE c.name IN ('Bebidas', 'Guarnições', 'Sobremesas')
        )
        ORDER BY RANDOM()
        LIMIT 4
    """)
    List<Product> findSuggestionsProducts();

}
