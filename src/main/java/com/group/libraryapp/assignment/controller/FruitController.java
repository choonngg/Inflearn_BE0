package com.group.libraryapp.assignment.controller;

import com.group.libraryapp.assignment.dto.request.FruitCreateRequest;
import com.group.libraryapp.assignment.dto.request.FruitUpdateIsSoldRequest;
import com.group.libraryapp.assignment.dto.response.FruitCountResponse;
import com.group.libraryapp.assignment.dto.response.FruitListResponse;
import com.group.libraryapp.assignment.dto.response.FruitSoldResponse;
import com.group.libraryapp.assignment.service.FruitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitService service;

    public FruitController(FruitService service) {
        this.service = service;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        service.saveFruit(request);
    }

    @GetMapping("/api/v1/fruit")
    public FruitSoldResponse salesAndNotSalesFruit(@RequestParam String name) {
        return service.salesAndNotSalesFruit(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse countFruit(String name) {
        return service.countFruit(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitListResponse> listFruit(@RequestParam String option, Long price) {
        return service.listFruit(option, price);
    }

    @PutMapping("/api/v1/fruit")
    public void updateIsSoldFruit(@RequestBody FruitUpdateIsSoldRequest request) {
        service.updateIsSoldFruit(request);
    }
}
