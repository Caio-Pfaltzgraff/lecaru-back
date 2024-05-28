package com.caiopfaltzgraff.lecaru.controller.admins;

import com.caiopfaltzgraff.lecaru.domain.unit.Address;
import com.caiopfaltzgraff.lecaru.domain.unit.Unit;
import com.caiopfaltzgraff.lecaru.dto.units.UnitsReadDTO;
import com.caiopfaltzgraff.lecaru.dto.units.UnitsSaveOrUpdateDTO;
import com.caiopfaltzgraff.lecaru.service.UnitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin/api/units")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class UnitController {

    private final UnitsService unitsService;

    @GetMapping
    public ResponseEntity<List<UnitsReadDTO>> getAllUnits() {
        return ResponseEntity.ok(
            unitsService.findAll().stream().map(unit -> new UnitsReadDTO(
                    unit.getId(),
                    unit.getName(),
                    unit.getAddress().getFu()
            )).toList()
        );
    }

    @GetMapping("{unitId}")
    public ResponseEntity<UnitsSaveOrUpdateDTO> getUnitById(@PathVariable String unitId) {
        var unit = unitsService.findById(unitId);
        return ResponseEntity.ok(
            new UnitsSaveOrUpdateDTO(
                unit.getName(),
                unit.getTelephone(),
                unit.getAddress().getZipCode(),
                unit.getAddress().getStreet(),
                unit.getAddress().getNeighborhood(),
                unit.getAddress().getCity(),
                unit.getAddress().getNumber(),
                unit.getAddress().getFu()
            )
        );
    }

    @PostMapping
    public ResponseEntity<Void> saveUnit(@RequestBody UnitsSaveOrUpdateDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var unit = unitsService.save(new Unit(
            null,
            data.name(),
            data.telephone(),
            new Address(
                data.zipCode(),
                data .street(),
                data.neighborhood(),
                data.city(),
                data.number(),
                data.fu()
            )
        ));

        var uri = uriComponentsBuilder.path("/admin/api/products/{unitId}").buildAndExpand(unit.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{unitId}")
    public ResponseEntity<Void> updateUnit(@PathVariable String unitId, @RequestBody UnitsSaveOrUpdateDTO dto) {
        unitsService.update(unitId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{unitId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String unitId) {
        unitsService.deleteById(unitId);
        return ResponseEntity.noContent().build();
    }

}
