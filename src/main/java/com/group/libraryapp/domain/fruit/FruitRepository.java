package com.group.libraryapp.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

//    void updateSoldById(Long id);

    Optional<Fruit> findByName(String name);

    @Query("SELECT SUM(f.price) FROM Fruit f WHERE f.isSold = true")
    Long sumPricesWhereIsSoldTrue();

    @Query("SELECT SUM(f.price) FROM Fruit f WHERE f.isSold = false")
    Long sumPriceWhereIsSoldFalse();
}
