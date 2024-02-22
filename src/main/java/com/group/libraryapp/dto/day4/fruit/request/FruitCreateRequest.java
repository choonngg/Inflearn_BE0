package com.group.libraryapp.dto.day4.fruit.request;

import java.time.LocalDate;

public class FruitCreateRequest {

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
