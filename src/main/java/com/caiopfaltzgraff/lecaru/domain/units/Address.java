package com.caiopfaltzgraff.lecaru.domain.units;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(nullable = false, length = 9)
    private String zipCode;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 100)
    private String neighborhood;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false, length = 2)
    private String fu;

    public String getFullAddress() {
        return street + ", " + number + " - " + neighborhood + ", " + city + " - " + fu + ", " + zipCode;
    }

}
