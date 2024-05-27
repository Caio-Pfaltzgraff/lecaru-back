package com.caiopfaltzgraff.lecaru.controller.admins;

import com.caiopfaltzgraff.lecaru.domain.subcategory.Subcategory;
import com.caiopfaltzgraff.lecaru.dto.products.ProductCreateDTO;
import com.caiopfaltzgraff.lecaru.dto.subcategories.SubcategoryReadDTO;
import com.caiopfaltzgraff.lecaru.dto.subcategories.SubcategorySaveOrUpdateDTO;
import com.caiopfaltzgraff.lecaru.service.CategoryService;
import com.caiopfaltzgraff.lecaru.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin/api/subcategories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<SubcategoryReadDTO>> getAllSubcategories() {
        return ResponseEntity.ok(subcategoryService.findAll().stream().map(
                s -> new SubcategoryReadDTO(s.getId(), s.getName(), s.getCategory().getId())
        ).toList());
    }

    @GetMapping("{subcategoryId}")
    public ResponseEntity<SubcategoryReadDTO> getSubcategory(@PathVariable Long subcategoryId) {
        var subcategory = subcategoryService.findById(subcategoryId);
        return ResponseEntity.ok(new SubcategoryReadDTO(subcategory.getId(), subcategory.getName(), subcategory.getCategory().getId()));
    }

    @PostMapping
    public ResponseEntity<Void> saveSubcategory(@RequestBody SubcategorySaveOrUpdateDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        var category = categoryService.findById(dto.categoryId());

        var subcategory = subcategoryService.save(new Subcategory(null, dto.name(), category));
        var uri = uriComponentsBuilder.path("/admin/api/products/{subcategoryId}").buildAndExpand(subcategory.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{subcategoryId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long subcategoryId, @RequestBody SubcategorySaveOrUpdateDTO dto) {
        subcategoryService.update(subcategoryId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{subcategoryId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long subcategoryId) {
        subcategoryService.deleteById(subcategoryId);
        return ResponseEntity.noContent().build();
    }
}
