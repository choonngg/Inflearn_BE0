package com.group.libraryapp.service.day6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import com.group.libraryapp.repository.day6.FruitRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(@Qualifier("fruitMemoryRepository") FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.saveFruit(request);
    }

    public void updateFruit(FruitUpdateRequest request) {
        fruitRepository.updateFruit(request);
    }

    public FruitSalesResponse salesFruit(String name) {
        return fruitRepository.salesFruit(name);
    }
}
