package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.domain.unit.Address;
import com.caiopfaltzgraff.lecaru.domain.unit.Unit;
import com.caiopfaltzgraff.lecaru.dto.api.StateFullNameAndFuDTO;
import com.caiopfaltzgraff.lecaru.dto.units.StatePageUnitsDTO;
import com.caiopfaltzgraff.lecaru.dto.units.UnitPageUnitsDTO;
import com.caiopfaltzgraff.lecaru.dto.units.UnitsSaveOrUpdateDTO;
import com.caiopfaltzgraff.lecaru.repository.UnitRepository;
import com.caiopfaltzgraff.lecaru.util.BrazilStates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitsService {

    private final UnitRepository unitRepository;

    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    public Unit findById(String id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found"));
    }

    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    public void update(String unitId, UnitsSaveOrUpdateDTO dto) {
        var unit = findById(unitId);

        unit.setName(dto.name());
        unit.setTelephone(dto.telephone());
        unit.setAddress(new Address(
            dto.zipCode(),
            dto.street(),
            dto.neighborhood(),
            dto.city(),
            dto.number(),
            dto.fu()
        ));

        unitRepository.save(unit);
    }

    public void deleteById(String id) {
        var unit = findById(id);
        unitRepository.delete(unit);
    }

    public List<StatePageUnitsDTO> getUnits() {
        var units = unitRepository.findAll();
        var states = new ArrayList<String>();

        units.forEach(unit -> {
            if(!states.contains(unit.getAddress().getFu())) {
                states.add(unit.getAddress().getFu());
            }
        });

        List<StateFullNameAndFuDTO> statesFullName = new ArrayList<StateFullNameAndFuDTO>();
        states.forEach(state -> {
            statesFullName.add(getStateFullName(state));
        });
        var data = new ArrayList<StatePageUnitsDTO>();

        statesFullName.forEach(state -> {
            var dataState = new StatePageUnitsDTO();
            dataState.setUnits(new ArrayList<>());
            dataState.setFu(state.fu());
            dataState.setName(state.name());
            data.add(dataState);
        });

        units.forEach(unit -> {
            data.forEach(state -> {
                if(unit.getAddress().getFu().equals(state.getFu())) {
                    state.getUnits().add(new UnitPageUnitsDTO(unit.getId(), unit.getName(), unit.getAddress().toFullAddresString(), unit.getTelephone()));
                }
            });
        });

        return data;
    }

    private StateFullNameAndFuDTO getStateFullName(String fu) {
        return new StateFullNameAndFuDTO(BrazilStates.getStateFullName(fu.toUpperCase()), fu.toUpperCase());
    }
}
