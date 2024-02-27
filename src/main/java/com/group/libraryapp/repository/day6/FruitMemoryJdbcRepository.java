package com.group.libraryapp.repository.day6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import org.springframework.stereotype.Repository;

@Repository
public class FruitMemoryJdbcRepository implements FruitJdbcRepository {

//    private final List<Fruit> fruits = new ArrayList<Fruit>();

    @Override
    public void saveFruit(FruitCreateRequest request) {
        System.out.println("FruitMemoryRepository.saveFruit");
    }

    @Override
    public void updateFruit(FruitUpdateRequest request) {

    }

    @Override
    public FruitSalesResponse salesFruit(String name) {
        return null;
    }
}
