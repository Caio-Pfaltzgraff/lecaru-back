package com.caiopfaltzgraff.lecaru.controller.admins;

import com.caiopfaltzgraff.lecaru.dto.categories.CategoryFilterDTO;
import com.caiopfaltzgraff.lecaru.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryFilterDTO>> getAllCategories() {
        var categories = categoryService.findAll().stream().map(
                c -> new CategoryFilterDTO(c.getId(), c.getName())
            ).toList();
        return ResponseEntity.ok(categories);
    }

}
