package com.caiopfaltzgraff.lecaru.dto.Menu;

import java.math.BigDecimal;

public record MenuProductInfoDTO(
        String name,
        String image,
        String description,
        BigDecimal price,
        Integer serving,
        Integer weight,
        String category,
        String subcategory
) {
}
