package com.caiopfaltzgraff.lecaru.controller.users;

import com.caiopfaltzgraff.lecaru.dto.home.HomeDataDTO;
import com.caiopfaltzgraff.lecaru.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home")
    public ResponseEntity<HomeDataDTO> getHomeData() {
        return ResponseEntity.ok(homeService.findProductsSuggestionsAndUnits());
    }

}
