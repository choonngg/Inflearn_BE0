package com.group.libraryapp.service.day6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import com.group.libraryapp.repository.day6.FruitJdbcRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV1 {

    private final FruitJdbcRepository fruitJdbcRepository;

    public FruitServiceV1(@Qualifier("fruitMemoryJdbcRepository") FruitJdbcRepository fruitJdbcRepository) {
        this.fruitJdbcRepository = fruitJdbcRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitJdbcRepository.saveFruit(request);
    }

    public void updateFruit(FruitUpdateRequest request) {
        fruitJdbcRepository.updateFruit(request);
    }

    public FruitSalesResponse salesFruit(String name) {
        return fruitJdbcRepository.salesFruit(name);
    }
}
