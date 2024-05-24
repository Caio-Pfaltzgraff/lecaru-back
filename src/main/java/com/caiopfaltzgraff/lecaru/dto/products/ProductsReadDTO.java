package com.caiopfaltzgraff.lecaru.dto.products;

public record ProductsReadDTO(
        String id,
        String name,
        String category,
        Long categoryId
) {
}
