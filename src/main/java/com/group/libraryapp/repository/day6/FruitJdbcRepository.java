package com.group.libraryapp.repository.day6;

import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;

public interface FruitJdbcRepository {

    public void saveFruit(FruitCreateRequest request);
    public void updateFruit(FruitUpdateRequest request);
    public FruitSalesResponse salesFruit(String name);
}
