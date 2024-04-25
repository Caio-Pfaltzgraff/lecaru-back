package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.dto.api.ResponseApiIBGEDTO;
import com.caiopfaltzgraff.lecaru.dto.api.StateFullNameAndFuDTO;
import com.caiopfaltzgraff.lecaru.dto.units.StatePageUnitsDTO;
import com.caiopfaltzgraff.lecaru.dto.units.UnitPageUnitsDTO;
import com.caiopfaltzgraff.lecaru.dto.units.UnitsDataDTO;
import com.caiopfaltzgraff.lecaru.repository.UnitRepository;
import com.caiopfaltzgraff.lecaru.util.RequestApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitsService {

    private final UnitRepository unitRepository;

    public UnitsDataDTO getUnits() {
        //buscar produtos
        var units = unitRepository.findAll();
        var states = new ArrayList<String>();

        units.forEach(unit -> {
            if(!states.contains(unit.getAddress().getFu())) {
                states.add(unit.getAddress().getFu());
            }
        });

        List<StateFullNameAndFuDTO> statesFullName = new ArrayList<StateFullNameAndFuDTO>();
        states.forEach(state -> {
            try {
                statesFullName.add(getStateFullName(state));
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var data = new UnitsDataDTO();
        data.setStates(new ArrayList<>());

        statesFullName.forEach(state -> {
            var dataState = new StatePageUnitsDTO();
            dataState.setUnits(new ArrayList<>());
            dataState.setFu(state.fu());
            dataState.setName(state.name());
            data.getStates().add(dataState);
        });

        units.forEach(unit -> {
            data.getStates().forEach(state -> {
                if(unit.getAddress().getFu().equals(state.getFu())) {
                    state.getUnits().add(new UnitPageUnitsDTO(unit.getId(), unit.getName(), unit.getAddress().toFullAddresString(), unit.getTelephone()));
                }
            });
        });

        return data;
    }

    private StateFullNameAndFuDTO getStateFullName(String fu) throws IOException, InterruptedException {
        String ibgeApiUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + fu;
        ResponseApiIBGEDTO response = new RequestApi().send(ibgeApiUrl, ResponseApiIBGEDTO.class);
        return new StateFullNameAndFuDTO(response.nome(), response.sigla());
    }

}
