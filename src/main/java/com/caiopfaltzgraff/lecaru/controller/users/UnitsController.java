package com.caiopfaltzgraff.lecaru.controller.users;

import com.caiopfaltzgraff.lecaru.domain.unit.Unit;
import com.caiopfaltzgraff.lecaru.dto.units.UnitsDataDTO;
import com.caiopfaltzgraff.lecaru.service.UnitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class UnitsController {

    private final UnitsService unitsService;

    @GetMapping
    public ResponseEntity<UnitsDataDTO> getUnits() {
        return ResponseEntity.ok(unitsService.getUnits());
    }

}
