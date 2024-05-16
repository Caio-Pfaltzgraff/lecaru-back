package com.caiopfaltzgraff.lecaru.controller.users;

import com.caiopfaltzgraff.lecaru.dto.Menu.MenuData;
import com.caiopfaltzgraff.lecaru.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
