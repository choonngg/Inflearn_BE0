package com.group.libraryapp.controller.day4_6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import com.group.libraryapp.service.day6.FruitService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request) {
        fruitService.updateFruit(request);
    }

    @GetMapping("/api/v1/fruit")
    public FruitSalesResponse salesFruit(@RequestParam String name) {
        return fruitService.salesFruit(name);
    }
}
