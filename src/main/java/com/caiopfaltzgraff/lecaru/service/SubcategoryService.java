package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.domain.subcategory.Subcategory;
import com.caiopfaltzgraff.lecaru.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    public Subcategory findById(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }

}
