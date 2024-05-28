package com.caiopfaltzgraff.lecaru.dto.units;

public record UnitsSaveOrUpdateDTO(
        String name,
        String telephone,
        String zipCode,
        String street,
        String neighborhood,
        String city,
        Integer number,
        String fu

) {
}
