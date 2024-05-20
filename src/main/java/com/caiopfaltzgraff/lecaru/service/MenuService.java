package com.caiopfaltzgraff.lecaru.service;

import com.caiopfaltzgraff.lecaru.domain.product.Product;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuCategory;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuData;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuProduct;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuSubcategory;
import com.caiopfaltzgraff.lecaru.repository.CategoryRepository;
import com.caiopfaltzgraff.lecaru.repository.ProductRepository;
import com.caiopfaltzgraff.lecaru.repository.SubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final ProductRepository productRepository;

    public MenuData getMenuData() {
        List<MenuCategory> categories = categoryRepository.findAll()
            .stream()
            .map(category -> new MenuCategory(category.getId(), category.getName(), category.getImage()))
            .toList();

        var subcategories = subcategoryRepository.findAll()
            .stream()
            .map(
                subcategory -> new MenuSubcategory(
                    subcategory.getId(), subcategory.getName(), subcategory.getCategory().getId()
                )
            )
            .toList();

        var products = productRepository.findAll()
            .stream()
            .map(product -> new MenuProduct(
                product.getId(),
                product.getName(),
                product.getImage(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getServing(),
                product.getCategory().getId(),
                product.getSubcategory().getId()
            ))
            .toList();

        return new MenuData(products, categories, subcategories);

    }

    public Product findByProductId(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

}
