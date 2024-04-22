package com.caiopfaltzgraff.lecaru.dto.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeDataDTO {

    private List<ProductHomeDTO> suggestions;
    private List<UnitHomeDTO> units;

}
