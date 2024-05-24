package com.caiopfaltzgraff.lecaru.controller.admins;

import com.caiopfaltzgraff.lecaru.dto.subcategories.SubcategoryReadDTO;
import com.caiopfaltzgraff.lecaru.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/subcategories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<SubcategoryReadDTO>> getAllSubcategories() {
        return ResponseEntity.ok(subcategoryService.findAll().stream().map(
                s -> new SubcategoryReadDTO(s.getId(), s.getName(), s.getCategory().getId())
        ).toList());
    }

}
