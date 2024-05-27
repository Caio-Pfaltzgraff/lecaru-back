package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.domain.subcategory.Subcategory;
import com.caiopfaltzgraff.lecaru.dto.subcategories.SubcategorySaveOrUpdateDTO;
import com.caiopfaltzgraff.lecaru.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryService categoryService;

    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    public Subcategory findById(Long id) {
        return subcategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Subcategory not found"));
    }

    public Subcategory save(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    public void update(Long id, SubcategorySaveOrUpdateDTO dto) {
        var subcategory = findById(id);

        subcategory.setName(dto.name());
        subcategory.setCategory(categoryService.findById(dto.categoryId()));

        save(subcategory);
    }

    public void deleteById(Long subcategoryId) {
        var subcategory = findById(subcategoryId);
        subcategoryRepository.delete(subcategory);
    }
}
