package com.caiopfaltzgraff.lecaru.dto.Menu;

import java.math.BigDecimal;

public record MenuProduct (
    String id,
    String name,
    String image,
    String description,
    BigDecimal price,
    Integer weight,
    Integer serving,
    Long categoryId,
    Long subcategoryId
) {}
