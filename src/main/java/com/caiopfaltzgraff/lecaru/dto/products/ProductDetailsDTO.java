package com.caiopfaltzgraff.lecaru.dto.products;

import java.math.BigDecimal;

public record ProductDetailsDTO(
        String id,
        String name,
        String description,
        String image,
        Integer weight,
        Integer serving,
        BigDecimal price,
        Long categoryId,
        Long subcategoryId
) {
}
