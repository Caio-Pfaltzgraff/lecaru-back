package com.caiopfaltzgraff.lecaru.controller.admins;

import com.caiopfaltzgraff.lecaru.domain.product.Product;
import com.caiopfaltzgraff.lecaru.dto.products.ProductCreateDTO;
import com.caiopfaltzgraff.lecaru.dto.products.ProductDetailsDTO;
import com.caiopfaltzgraff.lecaru.dto.products.ProductsReadDTO;
import com.caiopfaltzgraff.lecaru.service.CategoryService;
import com.caiopfaltzgraff.lecaru.service.ProductService;
import com.caiopfaltzgraff.lecaru.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    @GetMapping
    public ResponseEntity<List<ProductsReadDTO>> getAllProducts() {
        return ResponseEntity.ok(
            productService.findAll().stream().map(product -> new ProductsReadDTO(
                product.getId(),
                product.getName(),
                product.getCategory().getName(),
                product.getCategory().getId()
            ))
            .toList()
        );
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductDetailsDTO> getProductById(@PathVariable String productId) {
        var product = productService.findById(productId);
        return ResponseEntity.ok(
            new ProductDetailsDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImage(),
                product.getWeight(),
                product.getServing(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getSubcategory().getId()
            )
        );
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductCreateDTO data, UriComponentsBuilder uriComponentsBuilder) {
        var category = categoryService.findById(data.categoryId());
        var subcategory = subcategoryService.findById(data.subcategoryId());

        var product = productService.save(
            new Product(
                null,
                data.name(),
                data.description(),
                data.image(),
                data.weight(),
                data.serving(),
                data.price(),
                category,
                subcategory
            )
        );

        var uri = uriComponentsBuilder.path("/admin/api/products/{productId}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody ProductCreateDTO dto) {
        productService.update(productId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String productId) {
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }


}
