package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.dto.home.HomeDataDTO;
import com.caiopfaltzgraff.lecaru.dto.home.ProductHomeDTO;
import com.caiopfaltzgraff.lecaru.dto.home.UnitHomeDTO;
import com.caiopfaltzgraff.lecaru.repository.ProductRepository;
import com.caiopfaltzgraff.lecaru.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final ProductRepository productRepository;
    private final UnitRepository unitRepository;

    @Transactional(readOnly = true)
    public HomeDataDTO findProductsSuggestionsAndUnits() {
        var suggestionsList = productRepository.findSuggestionsProducts();
        var unitsList = unitRepository.findRandomUnits();

        var suggestions = suggestionsList.subList(0, suggestionsList.size()).stream().map(
                suggestion -> new ProductHomeDTO(
                        suggestion.getId(),
                        suggestion.getName(),
                        suggestion.getImage(),
                        suggestion.getDescription(),
                        suggestion.getPrice()
                )
        ).toList();

        var units = unitsList.subList(0, unitsList.size()).stream().map(
                unit -> new UnitHomeDTO(unit.getId(), unit.getName(), unit.getAddress().getFullAddress())
        ).toList();

        return new HomeDataDTO(suggestions, units);
    }

}
