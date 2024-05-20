package com.caiopfaltzgraff.lecaru.controller.users;

import com.caiopfaltzgraff.lecaru.domain.product.Product;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuData;
import com.caiopfaltzgraff.lecaru.dto.Menu.MenuProductInfoDTO;
import com.caiopfaltzgraff.lecaru.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<MenuData> getMenuData() {
        return ResponseEntity.ok(menuService.getMenuData());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<MenuProductInfoDTO> getProductById(@PathVariable String productId) {
        var product = menuService.findByProductId(productId);
        return ResponseEntity.ok(new MenuProductInfoDTO(
                product.getName(),
                product.getImage(),
                product.getDescription(),
                product.getPrice(),
                product.getServing(),
                product.getWeight(),
                product.getCategory().getName(),
                product.getSubcategory().getName()
        ));
    }

}
