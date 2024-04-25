package com.caiopfaltzgraff.lecaru.dto.units;

import lombok.Data;

import java.util.List;

@Data
public class StatePageUnitsDTO {

    private String name;
    private String fu;
    private List<UnitPageUnitsDTO> units;

}
