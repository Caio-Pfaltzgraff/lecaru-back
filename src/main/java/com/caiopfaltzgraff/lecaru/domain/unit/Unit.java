package com.caiopfaltzgraff.lecaru.domain.unit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "units")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(length = 100)
    private String name;

    @Column(length = 15, nullable = false)
    private String telephone;

    @Embedded
    private Address address;

}
