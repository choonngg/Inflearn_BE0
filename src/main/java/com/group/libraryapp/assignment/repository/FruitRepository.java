package com.group.libraryapp.assignment.repository;

import com.group.libraryapp.assignment.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findByNameAndIsSold(String name, boolean isSold);

    Long countByName(String name);

    List<Fruit> findByPriceGreaterThanEqualAndIsSold(Long price, boolean isSold);
    List<Fruit> findByPriceLessThanEqualAndIsSold(Long price, boolean isSold);
}
