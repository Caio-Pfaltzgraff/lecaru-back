package com.caiopfaltzgraff.lecaru.dto.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductHomeDTO {
    private String id;
    private String name;
    private String image;
    private String description;
    private BigDecimal price;
}
