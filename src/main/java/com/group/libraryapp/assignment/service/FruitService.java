package com.group.libraryapp.assignment.service;

import com.group.libraryapp.assignment.domain.Fruit;
import com.group.libraryapp.assignment.dto.request.FruitCreateRequest;
import com.group.libraryapp.assignment.dto.request.FruitUpdateIsSoldRequest;
import com.group.libraryapp.assignment.dto.response.FruitCountResponse;
import com.group.libraryapp.assignment.dto.response.FruitListResponse;
import com.group.libraryapp.assignment.dto.response.FruitSoldResponse;
import com.group.libraryapp.assignment.repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    // 4일차 - 문제 1
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate()));
    }

    // 4일차 - 문제 3
    public FruitSoldResponse salesAndNotSalesFruit(String name) {
        Long salesAmount = fruitRepository.findByNameAndIsSold(name, true).stream()
                .mapToLong(Fruit::getPrice).sum();
        Long notSalesAmount = fruitRepository.findByNameAndIsSold(name, false).stream()
                .mapToLong(Fruit::getPrice).sum();

        return new FruitSoldResponse(salesAmount, notSalesAmount);
    }

    // 7일차 - 문제 2
    public FruitCountResponse countFruit(String name) {
        Long count = fruitRepository.countByName(name);
        return new FruitCountResponse(count);
    }

    // 4일차 - 문제 2
    public void updateIsSoldFruit(FruitUpdateIsSoldRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruit.updateIsSold(fruit.getIsSold());
        fruitRepository.save(fruit);
    }

    // 7일차 - 문제 3
    public List<FruitListResponse> listFruit(String option, Long price) {
        if (!(option.equals("GTE") || option.equals("LTE"))) {
            throw new IllegalArgumentException();
        }

        if (option.equals("GTE")) {
            return fruitRepository.findByPriceGreaterThanEqualAndIsSold(price, false).stream()
                    .map((Fruit fruit) -> new FruitListResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
                    .collect(Collectors.toList());
        } else {
            return fruitRepository.findByPriceLessThanEqualAndIsSold(price, false).stream()
                    .map((Fruit fruit) -> new FruitListResponse(fruit.getName(), fruit.getPrice(), fruit.getWarehousingDate()))
                    .collect(Collectors.toList());
        }
    }
}
