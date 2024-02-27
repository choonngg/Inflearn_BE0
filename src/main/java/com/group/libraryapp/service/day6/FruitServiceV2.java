package com.group.libraryapp.service.day6;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.day4.fruit.request.FruitCreateRequest;
import com.group.libraryapp.dto.day4.fruit.request.FruitUpdateRequest;
import com.group.libraryapp.dto.day4.fruit.response.FruitSalesResponse;
import org.springframework.stereotype.Service;

@Service
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    // 과일 등록
    // warehousingDate는 생략했음(name과 price만)
    public void saveFruit(FruitCreateRequest request) {
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }

    // 과일 판매 업데이트
    public void updateFruit(FruitUpdateRequest request) {
        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

//        fruitRepository.updateSoldById(request.getId());
        fruit.updateIsSold(request.isSold());
        fruitRepository.save(fruit);
    }

    // 과일 판매, 미판매 총 금액
    public FruitSalesResponse salesFruit(String name) {
        fruitRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        long saleAmount = fruitRepository.sumPricesWhereIsSoldTrue();
        long notSalesAmount = fruitRepository.sumPriceWhereIsSoldFalse();

        return new FruitSalesResponse(saleAmount, notSalesAmount);
    }
}
