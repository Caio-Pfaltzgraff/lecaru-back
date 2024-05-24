package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.domain.product.Product;
import com.caiopfaltzgraff.lecaru.dto.products.ProductCreateDTO;
import com.caiopfaltzgraff.lecaru.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final SubcategoryService subcategoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void update(String id , ProductCreateDTO dto) {
        var product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setImage(dto.image());
        product.setWeight(dto.weight());
        product.setServing(dto.serving());
        product.setPrice(dto.price());
        product.setCategory(categoryService.findById(dto.categoryId()));
        product.setSubcategory(subcategoryService.findById(dto.subcategoryId()));

        productRepository.save(product);
    }

    public void deleteById(String id) {
        var product = findById(id);
        productRepository.delete(product);
    }

}
